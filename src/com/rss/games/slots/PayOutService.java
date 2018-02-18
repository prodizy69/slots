package com.rss.games.slots;

import com.rss.common.Constants;
import com.rss.pojo.*;
import com.rss.util.UtilService;

import java.util.ArrayList;
import java.util.Map;

public class PayOutService {
    private GameConfig gameConfig;
    private UtilService utilService;
    private Map<Integer,LinePatternObj> findSymbolLinePatternsMatches;
    private Map<Integer,Map<Integer,ArrayList<OfAKindObj>>> indexVsOfAKinds;
    private float betAmount;
    private float totalBetAmount;
    private Map<String,ArrayList<SymbolOccurance>> scatters;
    private Map<String,ArrayList<SymbolOccurance>> freeSpins;
    private float lineWinMultiplierValue_duringFreeSpins;
    private String orderType;
    private int columnsSize;
    private boolean pay_once;
    private ArrayList<PayOutObject> payOutObject = new ArrayList<>();

    public PayOutService(GameConfig gameConfig, UtilService utilService, Map<Integer, LinePatternObj> findSymbolLinePatternsMatches, Map<Integer, Map<Integer, ArrayList<OfAKindObj>>> indexVsOfAKinds, float betAmount, float totalBetAmount, Map<String, ArrayList<SymbolOccurance>> scatters, Map<String, ArrayList<SymbolOccurance>> freeSpins, float lineWinMultiplierValue_duringFreeSpins, String orderType, int columnsSize, boolean pay_once) {
        this.gameConfig = gameConfig;
        this.utilService = utilService;
        this.findSymbolLinePatternsMatches = findSymbolLinePatternsMatches;
        this.indexVsOfAKinds = indexVsOfAKinds;
        this.betAmount = betAmount;
        this.totalBetAmount = totalBetAmount;
        this.scatters = scatters;
        this.freeSpins = freeSpins;
        this.lineWinMultiplierValue_duringFreeSpins = lineWinMultiplierValue_duringFreeSpins;
        this.orderType = orderType;
        this.columnsSize = columnsSize;
        this.pay_once = pay_once;
    }

    public PayOutResponse findTotalPayOut(){
        float totalPayOut = 0;
        ArrayList<FreeSpinObj> freeSpins = new ArrayList();
        ArrayList<String> bonusGames = new ArrayList();
        PayOutObject payOutObj = new PayOutObject();
        int index=0;
        for(Map.Entry<Integer,Map<Integer,ArrayList<OfAKindObj>>> entry : indexVsOfAKinds.entrySet()){
            int key = entry.getKey();
            Map<Integer,ArrayList<OfAKindObj>> rankings = entry.getValue();
            totalPayOut = this.addAmounts(totalPayOut , this.findTotalPerPayLine(index,rankings,this.betAmount,this.totalBetAmount));
            index++;
        }

        payOutObj.setWinAmount(this.getAmount(totalPayOut));
        ArrayList<SymbolOccurance> scatterOccurances=null;
        if(this.scatters != null && this.scatters.size() > 0){
            PayOutResponse scattersOutPut = this.findScatterPayOut(this.betAmount,this.totalBetAmount);
            totalPayOut = this.addAmounts(totalPayOut , scattersOutPut.getPayOut());
            freeSpins.addAll(scattersOutPut.getFreeSpins());
            bonusGames.addAll(scattersOutPut.getBonusGames());
            payOutObj.setScatterWinAmount(this.getAmount(scattersOutPut.getPayOut()));
            scatterOccurances = scattersOutPut.getScatterOccurances();
        }
        System.out.println("DINESH:"+this.freeSpins);
        if(this.freeSpins != null  && this.freeSpins.size() > 0){
            PayOutResponse freeSpinOutPut = this.findFreeSpinsPayOut(this.betAmount,this.totalBetAmount);
            totalPayOut = this.addAmounts(totalPayOut , freeSpinOutPut.getPayOut());
            freeSpins.addAll(freeSpinOutPut.getFreeSpins());
            bonusGames.addAll(freeSpinOutPut.getBonusGames());
            payOutObj.setFreeSpinWinAmount(this.getAmount(freeSpinOutPut.getPayOut()));
        }
        payOutObj.setTotalPayOut(this.getAmount(totalPayOut));
        PayOutResponse response =  new PayOutResponse();
        response.setPayOutObject(this.payOutObject);
        response.setTotalPayOutObj(payOutObj);
        response.setFreeSpins(freeSpins);
        response.setBonusGames(bonusGames);
        response.setScatterOccurances(scatterOccurances);
        return response;
    }

    public float findTotalPerPayLine(int payLineIndex,Map<Integer,ArrayList<OfAKindObj>> rankingsForCombinations,float betAmount,float totalBetAmount){
        float payOutPerPayLine = 0;

        ArrayList<OfAKindObj> combinationUsed = null;


        for(Map.Entry<Integer,ArrayList<OfAKindObj>> entry : rankingsForCombinations.entrySet()){
            ArrayList<OfAKindObj> rankings = entry.getValue();
            float combinationPayOut=0;
            boolean alreadyPaid=false;
            for(OfAKindObj ofAKindObj : rankings){
                float multiplier=0;
                if(!alreadyPaid && (this.utilService.isGivenType(ofAKindObj.getSymbol(), Constants.WILD)
                        || this.utilService.isGivenType(ofAKindObj.getSymbol(),Constants.REGULAR))){
                    if(ofAKindObj.getCount() == this.columnsSize && this.pay_once){
                        alreadyPaid = true;
                    }
                    multiplier = this.utilService.getSymbolMultiplerForGivenOfAKind(ofAKindObj.getSymbol(), ofAKindObj.getCount());
                    float ofAKindPay = 0;
                    if(multiplier > 0){
                        ofAKindObj.setUsed(true);
                        ofAKindPay = this.getAmount(this.multiplyNumbers(betAmount , multiplier));
                        if(ofAKindObj.getWildObj() != null && !this.utilService.isGivenType(ofAKindObj.getSymbol(),Constants.WILD)){
                            if(ofAKindObj.getWildObj().getMultiplier() > 0){
                                ofAKindPay = this.getAmount(this.multiplyNumbers(ofAKindObj.getWildObj().getMultiplier() , ofAKindPay));
                            }
                        }
                        if(this.lineWinMultiplierValue_duringFreeSpins > 0){
                            ofAKindPay = this.getAmount(this.multiplyNumbers(ofAKindPay , this.lineWinMultiplierValue_duringFreeSpins));
                        }

                        if(this.orderType.equalsIgnoreCase(Constants.ORDER_TYPE_ANYWHERE)){
                            if(ofAKindPay > combinationPayOut){
                                combinationPayOut = ofAKindPay;
                            }else{
                                ofAKindObj.setUsed(false);
                            }
                        }else {
                            combinationPayOut = this.getAmount(this.addAmounts(combinationPayOut,ofAKindPay));
                        }
                        ofAKindObj.setWinAmount(ofAKindPay);
                    }else{
                        ofAKindObj.setUsed(false);
                    }
                }
            }
            if(combinationPayOut > payOutPerPayLine){
                payOutPerPayLine = combinationPayOut;
                combinationUsed = rankings;
            }
        }

        LinePatternObj symbolLinePatternMatchedObj = this.findSymbolLinePatternsMatches.get(payLineIndex);
        LinePatternObj linePatternUsed=null;
        boolean linePattern = false;
        if(symbolLinePatternMatchedObj != null){
            float patternPayAmount = this.getAmount(this.multiplyNumbers(betAmount , symbolLinePatternMatchedObj.getOfAKindPayConfigArray()[0].getLineBetMultiplierValue()));
            if(this.lineWinMultiplierValue_duringFreeSpins > 0){
                patternPayAmount = this.getAmount(this.multiplyNumbers(patternPayAmount , this.lineWinMultiplierValue_duringFreeSpins));
            }
            if(patternPayAmount > payOutPerPayLine){
                payOutPerPayLine = patternPayAmount;
                linePatternUsed = symbolLinePatternMatchedObj;
                linePattern = true;
            }
        }

        if(payOutPerPayLine > 0){
            PayOutObject tmp = new PayOutObject();
            tmp.setBetLineIndex(payLineIndex);
            tmp.setWindowMatrix(combinationUsed);
            tmp.setLinePattern(linePattern);
            tmp.setLinePatternUsed(linePatternUsed);
            tmp.setWinAmount(payOutPerPayLine);
            this.payOutObject.add(tmp);
        }
        return this.getAmount(payOutPerPayLine);
    }

    private PayOutResponse findScatterPayOut(float betAmount,float totalBetAmount){
        String payType = this.gameConfig.getSymbol_paytable_common().getSCATTERS().getPayMethod();
        String symbolToBeConsider = null;
        if(payType.equalsIgnoreCase(Constants.SCATTER_PAYOUT_TYPE.get("PAY_BY_PRIORITY"))) {
            symbolToBeConsider = this.getFirstPriorityScatterSymbol(this.scatters,this.gameConfig.getSymbol_paytable_common().getSCATTERS().getSymbolAliasPriorityArray());
        }
        return this.findPayoutAndFreeSpins(betAmount,totalBetAmount,this.scatters,true,payType,symbolToBeConsider);
    }

    private PayOutResponse findFreeSpinsPayOut(float betAmount,float totalBetAmount){
        return this.findPayoutAndFreeSpins(betAmount,totalBetAmount,this.freeSpins,false,null,null);
    }
    private PayOutResponse findPayoutAndFreeSpins(float betAmount,float totalBetAmount,Map<String,ArrayList<SymbolOccurance>> symbolOccurances,
                                         boolean isScatter,String payType,String symbolToBeConsider){
        float payOut = 0;
        ArrayList<FreeSpinObj> freeSpins = new ArrayList<>();
        ArrayList<String> bonusGames = new ArrayList<>();
        ArrayList<SymbolOccurance> scatterOccurances = new ArrayList<>();

        for(Map.Entry<String,ArrayList<SymbolOccurance>> entry: symbolOccurances.entrySet()){
            String symbol = entry.getKey();
            ArrayList<SymbolOccurance> occurances = entry.getValue();
            OfAKindObj ofAKindConfig = this.utilService.getSymbolOfAkindObject(symbol,occurances.size());

            float totalBetMultipler = ofAKindConfig.getTotalBetMultiplierValue();
            boolean isUsed=false;

            if(totalBetMultipler > 0){
                if(this.lineWinMultiplierValue_duringFreeSpins > 0){
                    totalBetMultipler = this.getAmount(this.multiplyNumbers(totalBetMultipler , this.lineWinMultiplierValue_duringFreeSpins));
                }
                System.out.println("totalBetAmount:"+totalBetAmount+":totalBetMultipler:"+totalBetMultipler);
                float amountToPay = this.getAmount(this.multiplyNumbers(totalBetAmount , totalBetMultipler));
                if(isScatter) {
                    if(payType.equalsIgnoreCase(Constants.SCATTER_PAYOUT_TYPE.get("SUM_OF_ALL_PAYS"))){
                        payOut = this.addAmounts(payOut , amountToPay);
                        isUsed=true;
                    }else if (payType.equalsIgnoreCase(Constants.SCATTER_PAYOUT_TYPE.get("MAX_OF_ALL_PAYS"))){
                        if(amountToPay > payOut){
                            payOut = amountToPay;
                            isUsed=true;
                        }
                    }else if(payType.equalsIgnoreCase(Constants.SCATTER_PAYOUT_TYPE.get("PAY_BY_PRIORITY"))){
                        System.out.println("payOut:"+payOut+":amountToPay:"+amountToPay+":symbol:"+symbol+":symbolToBeConsider:"+symbolToBeConsider);
                        if(symbol.toLowerCase() == symbolToBeConsider){
                            payOut = amountToPay;
                            isUsed=true;
                        }
                        System.out.println("payOut:"+payOut+":amountToPay:"+amountToPay);
                    }
                }else{
                    payOut = this.addAmounts(payOut , amountToPay);
                    isUsed=true;
                }
                //console.log("symbol:"+symbol+":payOut:"+payOut);
            }
            System.out.println("ofAKindConfig:"+ofAKindConfig+":ofAKindConfig.hasFreeSpins:"+ofAKindConfig.getHasFreespins()
                    +":ofAKindConfig.freeSpinsGameConfigArray:"+ofAKindConfig.getFreeSpinsGameConfigArray());
            if(ofAKindConfig.getHasFreespins().equalsIgnoreCase("true")) {
                for(FreeSpinObj freeSpinObj : ofAKindConfig.getFreeSpinsGameConfigArray()) {
                    freeSpinObj.setSymbol(symbol);
                    System.out.println("freeSpinObj:"+freeSpinObj);
                    freeSpins.add(freeSpinObj);
                    isUsed=true;
                }
            }
            if(isUsed) {
                scatterOccurances=occurances;
            }
        }
        return new PayOutResponse(
                this.getAmount(payOut),
                freeSpins,bonusGames,scatterOccurances
        );
    }
    private String getFirstPriorityScatterSymbol(Map<String,ArrayList<SymbolOccurance>> symbolOccurances,String[] symbolAliasPriorityArray){
        for(String symbol : symbolAliasPriorityArray){
            symbol = symbol.toLowerCase();
            if(symbolOccurances.get(symbol) != null) {
                return symbol;
            }
        }
        return null;
    }
    private float getAmount(float amount){
        return (float) (Math.floor(amount * 100) / 100);
    }

    private  float multiplyNumbers(float amount1, float amount2){
        amount1 = this.getAmount(amount1 * 100);
        amount2 = this.getAmount(amount2 * 100);
        return ((amount1 * amount2)/10000);
    }

    private float addAmounts(float amount1, float amount2){
        amount1 = this.getAmount(amount1 * 100);
        amount2 = this.getAmount(amount2 * 100);
        return ((amount1 + amount2)/100);
    }
}
