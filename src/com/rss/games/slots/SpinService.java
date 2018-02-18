package com.rss.games.slots;

import com.rss.common.Constants;
import com.rss.config.Configuration;
import com.rss.games.slots.combinations.OrderCombinations;
import com.rss.pojo.*;
import com.rss.util.UtilService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpinService {
    private GameConfig gameConfig;
    private UtilService utilService;
    private Map<Integer, ArrayList<SpecialWildObj>> oldWilds;
    private Map<Integer, ArrayList<SpecialWildObj>> oldWildsFree;
    private int[][][] play_linesArray;

    public SpinService(GameConfig gameConfig, UtilService utilService, Map<Integer, ArrayList<SpecialWildObj>> oldWilds, Map<Integer, ArrayList<SpecialWildObj>> oldWildsFree,
                       int[][][] play_linesArray) {
        this.gameConfig = gameConfig;
        this.utilService = utilService;
        this.oldWilds = oldWilds;
        this.oldWildsFree = oldWildsFree;
        this.play_linesArray = play_linesArray;
    }

    public PayOutResponse spin(int index, String spinType,float betAmount,float totalBetAmount,float lineWinMultiplierValue_duringFreeSpins){
        Map<String,SymbolObj>  allSymbolObjects = this.utilService.getAllSymbols();
        for(Map.Entry<String,SymbolObj> entry : allSymbolObjects.entrySet()){
            String symbolName = entry.getKey();
            SymbolObj symbolObject = entry.getValue();
            System.out.println("Symbol Name:"+symbolName+":ofAkind:"+symbolObject.getOfAKindPayConfigArray());
        }

        OrderCombinations orderCombinations = new OrderCombinations(this.gameConfig,this.utilService);

        ReelSet reelSet = this.gameConfig.getReel_set_config_array().get(index);
        Integer[] foOutPut = null;
        if(!Configuration.getInstance().get("SETUP").equalsIgnoreCase(Constants.SETUP_TYPES.get("LIVE")) &&
                this.gameConfig.getFo_config() != null){
            foOutPut = this.gameConfig.getFo_config();
        }
        RngService rngService = new RngService(reelSet.getReelStripLengths_Array(),reelSet.getReelStripsData_ArrayArray(),
                this.gameConfig.getPlay_window().getRows(),foOutPut);

        String[][] cprngOutPut = rngService.generate();

        Map<Integer, ArrayList<SpecialWildObj>> oldWildsTmp = this.oldWilds;
        Map<Integer, ArrayList<SpecialWildObj>> oldWildsFreeTmp = this.oldWildsFree;

        Map<Integer, ArrayList<SpecialWildObj>> oldWilds= null;

        boolean usingFreeOldWilds = false;
        if(spinType.equalsIgnoreCase(Constants.SPIN_TYPE_FREE)){
            oldWilds=oldWildsFreeTmp;
        }else{
            oldWilds=oldWildsTmp;
        }


        SpecialWildsService specialWildService = new SpecialWildsService(
                gameConfig, utilService, cprngOutPut,
                oldWilds);
        SubstitutionResponse afterSpecialWildSubstitution = specialWildService.doSubstitution();

        if(spinType.equalsIgnoreCase(Constants.SPIN_TYPE_FREE)){
            this.oldWildsFree = afterSpecialWildSubstitution.getOldWilds();
        }else{
            this.oldWildsFree = null;
            this.oldWilds = afterSpecialWildSubstitution.getOldWilds();
        }


        PayLinesConstructor play_linesService = new PayLinesConstructor(this.gameConfig, afterSpecialWildSubstitution.getRng(),this.play_linesArray);
        String[][] play_linesWithRNGOutPut = play_linesService.construct();

        Map<Integer,LinePatternObj> symbolLinePatternsMatches = orderCombinations.findSymbolLinePatternsMatches(play_linesWithRNGOutPut);
        //System.out.println("symbolLinePatternsMatches:"+symbolLinePatternsMatches);
        Map<String,ArrayList<SymbolOccurance>>  scatterSymbols = orderCombinations.findGivenTypeOnPlayWindow(afterSpecialWildSubstitution.getRng(),Constants.SCATTER);
        Map<String,ArrayList<SymbolOccurance>>  freeSpinSymbols = orderCombinations.findGivenTypeOnPlayWindow(afterSpecialWildSubstitution.getRng(),Constants.FREESPIN);

        Map<Integer,Map<Integer,ArrayList<OfAKindObj>>>   rankings = new HashMap<>();

        if(this.gameConfig.getGame_order() != null) {
            this.gameConfig.setGame_order(Constants.ORDER_TYPE_L2R); //TODO default initialization to L2R configuration
        }

        if (this.gameConfig.getGame_order().equalsIgnoreCase(Constants.ORDER_TYPE_L2R)) {
            rankings = this.findRankings(orderCombinations.findL2R(play_linesWithRNGOutPut), this.gameConfig.getGame_order());
        } else if (this.gameConfig.getGame_order().equalsIgnoreCase(Constants.ORDER_TYPE_R2L)) {
            rankings = this.findRankings(orderCombinations.findR2L(play_linesWithRNGOutPut), this.gameConfig.getGame_order());
        } else if (this.gameConfig.getGame_order().equalsIgnoreCase(Constants.ORDER_TYPE_BOTH)) {
            rankings = this.findRankings(orderCombinations.findL2RAndR2L(play_linesWithRNGOutPut), this.gameConfig.getGame_order());
        } else if (this.gameConfig.getGame_order().equalsIgnoreCase(Constants.ORDER_TYPE_ANYWHERE)) {
            rankings = this.findRankings(orderCombinations.findAnyWhere(play_linesWithRNGOutPut),this.gameConfig.getGame_order());
        }

        PayOutResponse payOutOutPut = this.doPayOut(rankings, betAmount, totalBetAmount, scatterSymbols, freeSpinSymbols, lineWinMultiplierValue_duringFreeSpins, symbolLinePatternsMatches);
        payOutOutPut.setRng(afterSpecialWildSubstitution.getRng());
        payOutOutPut.setBeforeSubstitution(afterSpecialWildSubstitution.getBeforeSubstitution());
        payOutOutPut.setOldWildsFree(this.oldWildsFree);
        payOutOutPut.setOldWilds(this.oldWilds);
        payOutOutPut.setRngOutPut(cprngOutPut);
        payOutOutPut.setReel_set_index(index);
        payOutOutPut.setSpin_type(spinType);
        payOutOutPut.setTriggerGamble(false);
        if(payOutOutPut.getSpin_type().equalsIgnoreCase(Constants.SPIN_TYPE_NORMAL) && this.gameConfig.isGamble_enabled() == true && payOutOutPut.getTotalPayOutObj().getTotalPayOut() > 0){
            payOutOutPut.setTriggerGamble(true);
        }
        return payOutOutPut;

    }

    private PayOutResponse doPayOut(Map<Integer,Map<Integer,ArrayList<OfAKindObj>>>  rankings,
                          float betAmount,float totalBetAmount,
                          Map<String,ArrayList<SymbolOccurance>>  scatterSymbols,Map<String,ArrayList<SymbolOccurance>>  freeSpinSymbols,
                          float lineWinMultiplierValue_duringFreeSpins,Map<Integer,LinePatternObj>  symbolLinePatternsMatches){
        PayOutService payOutService = new PayOutService(
                this.gameConfig,this.utilService,symbolLinePatternsMatches,rankings,betAmount,totalBetAmount,scatterSymbols,freeSpinSymbols,lineWinMultiplierValue_duringFreeSpins,this.gameConfig.getGame_order(),
                this.gameConfig.getPlay_window().getCols(),this.gameConfig.isPay_once()
        );
        PayOutResponse payOutOutPut = payOutService.findTotalPayOut();
        float payOutAmount = payOutOutPut.getPayOut();
        ////console.log("PayOut:"+JSON.stringify(payOutOutPut));
    /*
    if(payOutAmount > 0 ){
        var gsInstance = new GS.GambleService(this.gameConfig, this.utilService);
        gsInstance.processGamble(payOutAmount,constants.GAMBLE_TYPE_COLOR,constants.GAMBLE_COLOR_VALUES.black);
        gsInstance.processGamble(payOutAmount,constants.GAMBLE_TYPE_SUITE,constants.GAMBLE_SUITE_VALUES.club);
    }
    */
        return payOutOutPut;

    }
    private Map<Integer,Map<Integer,ArrayList<OfAKindObj>>>  findRankings(Map<Integer, ArrayList<String>> indexVsCombinations,String type){
        indexVsCombinations = this.removeDuplicates(indexVsCombinations, type);
        RankingService rsInstance = new RankingService(indexVsCombinations,this.gameConfig, type,this.utilService,gameConfig.getPlay_window().getCols());
        Map<Integer,Map<Integer,ArrayList<OfAKindObj>>>  outPut = rsInstance.find();
        return outPut;
    }

    private Map<Integer, ArrayList<String>> removeDuplicates(Map<Integer, ArrayList<String>> indexVsCombinations,String type){
        Map<Integer, ArrayList<String>> newIndexVsCombinations = new HashMap<>();
        //console.log(type);
        for(Map.Entry<Integer, ArrayList<String>> entry : indexVsCombinations.entrySet()){
            ArrayList<String> combinations = entry.getValue();
            ArrayList<String> newCombinations = new ArrayList<>();
            for(String combination : combinations){
                if(!newCombinations.contains(combination)){
                    newCombinations.add(combination);
                }
            }
            newIndexVsCombinations.put(entry.getKey(),newCombinations);
        }
        return newIndexVsCombinations;
    }
}
