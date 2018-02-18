package com.rss.test;

import com.rss.common.Constants;
import com.rss.config.Configuration;
import com.rss.games.slots.SpinService;
import com.rss.pojo.*;
import com.rss.util.UtilService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestSpin {
    float betAmount = 2;
    float totalBetAmount = 20;
    float lineWinMultiplierValue_duringFreeSpins=0;

    String spinType = Constants.SPIN_TYPE_NORMAL;
    int index = 0;

    public TestSpin(float betAmount, float totalBetAmount, float lineWinMultiplierValue_duringFreeSpins, String spinType, int index) {
        this.betAmount = betAmount;
        this.totalBetAmount = totalBetAmount;
        this.lineWinMultiplierValue_duringFreeSpins = lineWinMultiplierValue_duringFreeSpins;
        this.spinType = spinType;
        this.index = index;
    }

    public void test(GameConfig gameConfig, UtilService utilService){
        Map<Integer, ArrayList<SpecialWildObj>> oldWilds = new HashMap<>();
        Map<Integer, ArrayList<SpecialWildObj>> oldWildsFree = new HashMap<>();
        SpinService spinService = new SpinService(
                gameConfig,utilService, oldWilds,oldWildsFree,gameConfig.getPlay_lines().getWindowMatrix_Array());
        PayOutResponse payOutOutPut = spinService.spin(index, spinType, betAmount, totalBetAmount, lineWinMultiplierValue_duringFreeSpins);
        ArrayList<FreeSpinObj>  freeSpins = payOutOutPut.getFreeSpins();
        int maxFreeSpins = 4;
        int count = 0;
        if (freeSpins != null && freeSpins.size() > 0) {
            count++;
            //processFreeSpinsIfAny(spinService,freeSpins,maxFreeSpins,count);
        }
    }

    public void processFreeSpinsIfAny(SpinService spinService,ArrayList<FreeSpinObj>  freeSpins,int maxFreeSpins,int count ){
        if(count >= maxFreeSpins){
            return;
        }
        System.out.println("freeSpins:"+freeSpins);

        for(FreeSpinObj freeSpinObject : freeSpins){
            //System.out.println("freeSpinNumber:"+freeSpinNumber);
            float lineWinMultiplierValue_duringFreeSpins = freeSpinObject.getLineWinMultiplierValue_duringFreeSpins();
            float index = 0;
            for(int spinIndex=0;spinIndex<freeSpinObject.getFreeSpinsCount();spinIndex++) {
                //System.out.println("free spinIndex:"+spinIndex);
                PayOutResponse payOutOutPut= spinService.spin(this.index, Constants.SPIN_TYPE_FREE, betAmount, totalBetAmount, lineWinMultiplierValue_duringFreeSpins);
                ArrayList<FreeSpinObj>  freeSpinsTmp = payOutOutPut.getFreeSpins();
                if(freeSpinsTmp != null && freeSpinsTmp.size() > 0){
                    if(count < maxFreeSpins) {
                        count++;
                        processFreeSpinsIfAny(spinService,freeSpinsTmp,maxFreeSpins,count);
                    }
                }
            }
            count--;
        }
    }

    public static void main(String args[]){
        Configuration.getInstance().set("SETUP","LIVE");
        GameConfig gameConfig = new GameConfig();
        PlayWindow playWindow = new PlayWindow();
        playWindow.setCols(7);
        playWindow.setRows(7);

        int[][] windowMatrix = new int[playWindow.getRows()][playWindow.getCols()];
        for(int index=0;index<playWindow.getCols();index++){
            windowMatrix[index]=new int[]{1,1,1,1,1,1,1};
        }
        gameConfig.setPlay_window(playWindow);
        PlayLines playLines = new PlayLines();
        playLines.setAllWaysSlots(false);
        int[][][] windowMatrix_Array = new int[7][playWindow.getRows()][playWindow.getCols()];
        for(int x=0;x<7;x++) {
            windowMatrix_Array[x] =  new int[7][7];
            for (int index = 0; index < playWindow.getCols(); index++) {
                if(x == index){
                    windowMatrix_Array[x][index] = new int[]{2,2,2,2,2,2,2};
                }else {
                    windowMatrix_Array[x][index] = new int[]{1, 1, 1, 1, 1, 1, 1};
                }
            }
        }
        playLines.setWindowMatrix_Array(windowMatrix_Array);
        gameConfig.setPlay_lines(playLines);

        ArrayList<SymbolObj> symbol_paytable = new ArrayList<>();
        SymbolObj symbolObj = new SymbolObj();
        symbolObj.setSymbolAlias("r1");
        symbolObj.setSymbolType("Regular Symbol");

        OfAKindObj[] ofAKindPayConfigArray = new OfAKindObj[]{
                new OfAKindObj(1,0),
                new OfAKindObj(1,1),
                new OfAKindObj(1,2),
                new OfAKindObj(1,3),
                new OfAKindObj(1,4),
                new OfAKindObj(2,5),
                new OfAKindObj(4,6)
        };

        symbolObj.setOfAKindPayConfigArray(ofAKindPayConfigArray);
        symbolObj.setCommonPayConfig(new PayConfig(new HashMap<>()));
        symbol_paytable.add(symbolObj);


        symbolObj = new SymbolObj();
        symbolObj.setSymbolAlias("r2");
        symbolObj.setSymbolType("Regular Symbol");

        ofAKindPayConfigArray = new OfAKindObj[]{
                new OfAKindObj(1,0),
                new OfAKindObj(1,1),
                new OfAKindObj(1,2),
                new OfAKindObj(1,3),
                new OfAKindObj(1,4),
                new OfAKindObj(2,5),
                new OfAKindObj(4,6)
        };

        symbolObj.setOfAKindPayConfigArray(ofAKindPayConfigArray);
        symbolObj.setCommonPayConfig(new PayConfig(new HashMap<>()));
        symbol_paytable.add(symbolObj);

        symbolObj = new SymbolObj();
        symbolObj.setSymbolAlias("est1");
        symbolObj.setSymbolType("Wild Symbol");

        ofAKindPayConfigArray = new OfAKindObj[]{
                new OfAKindObj(20,0),
                new OfAKindObj(30,1),
                new OfAKindObj(40,2),
                new OfAKindObj(50,3),
                new OfAKindObj(60,4),
                new OfAKindObj(70,5),
                new OfAKindObj(80,6)
        };

        symbolObj.setOfAKindPayConfigArray(ofAKindPayConfigArray);
        //symbolObj.setCommonPayConfig(new PayConfig(new HashMap<>()));
        PayConfig payConfig = new PayConfig();
        payConfig.setSpecialWildType("Expanding Sticky Wild");
        payConfig.setStickySpinCount(3);
        payConfig.setWildSubstitutionMultiplierValue(3);
        symbolObj.setCommonPayConfig(payConfig);
        Map<String,Boolean> mapping = new HashMap<>();
        mapping.put("r1",true);
        mapping.put("r2",false);
        symbol_paytable.add(symbolObj);
        gameConfig.setSymbol_paytable(symbol_paytable);

        SymbolPayTable symbol_paytable_common = new SymbolPayTable();
        ScatterObj scatterObj = new ScatterObj();
        scatterObj.setPayMethod("SUM_OF_ALL_PAYS");
        scatterObj.setSymbolAliasPriorityArray(new String[]{"s1"});
        symbol_paytable_common.setSCATTERS(scatterObj);
        gameConfig.setSymbol_paytable_common(symbol_paytable_common);

        gameConfig.setPaylines_paytable(new ArrayList<LinePatternObj>());


        ArrayList<ReelSet> reel_set_config_array = new ArrayList<>();
        ReelSet reelSet = new ReelSet();
        reelSet.setReelSetName("Reel Set 1");
        reelSet.setReelStripLengths_Array(new int[]{20,7,7,7,7,7,7});
        String[][] reelStripsData_ArrayArray = new String[7][];
        reelStripsData_ArrayArray[0] = new String[]{"r1","r1","r1","r2","r2","r1","r1","r1","r1","est1","r1","est1","r2","r2","r1","r1","r2","r2","r2","est1"};
        reelStripsData_ArrayArray[1] = new String[]{"r1","est1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[2] = new String[]{"est1","r1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[3] = new String[]{"r1","r1","est1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[4] = new String[]{"est1","r1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[5] = new String[]{"r1","est1","r1","r2","r2","r1","r1"};
        reelStripsData_ArrayArray[6] = new String[]{"r1","est1","r1","r2","r2","r1","r1"};

        reelSet.setReelStripsData_ArrayArray(reelStripsData_ArrayArray);
        reel_set_config_array.add(reelSet);
        gameConfig.setReel_set_config_array(reel_set_config_array);

        gameConfig.setFg_config(null);
        gameConfig.setFo_config(null);
        gameConfig.setGame_order("L2R");
        gameConfig.setGamble_enabled(true);
        gameConfig.setPay_once(false);


        UtilService utilService = new UtilService(gameConfig);
        TestSpin testObj = new TestSpin(10,100,1, Constants.SPIN_TYPE_NORMAL,0);
        testObj.test(gameConfig,utilService);
    }
}
