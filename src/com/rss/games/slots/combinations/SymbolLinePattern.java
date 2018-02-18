package com.rss.games.slots.combinations;

import com.rss.pojo.GameConfig;
import com.rss.pojo.LinePatternObj;
import com.rss.util.UtilService;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SymbolLinePattern {
    private GameConfig gameConfig;
    private UtilService utilService;
    private ArrayList<LinePatternObj> paylines_paytable;

    public SymbolLinePattern(GameConfig gameConfig, UtilService utilService) {
        this.gameConfig = gameConfig;
        this.utilService = utilService;
        this.paylines_paytable = gameConfig.getPaylines_paytable();
    }

    public LinePatternObj findMatches(String[] payLine){
        LinePatternObj matchedLinePatternObj = null;
        float multiplier = 0;
        for(LinePatternObj linePatternObj : this.paylines_paytable){
            String[] linePattern = linePatternObj.getLinePatternArray();
            boolean matched = true;
            for(int payLineIndex=0;payLineIndex<payLine.length;payLineIndex++){
                linePattern[payLineIndex]= linePattern[payLineIndex].toLowerCase().trim();
                if(!payLine[payLineIndex].toLowerCase().equalsIgnoreCase(linePattern[payLineIndex]) && !linePattern[payLineIndex].equalsIgnoreCase("any")){
                    matched = false;
                }
            }
            if(matched){
                float newMultiplier = linePatternObj.getOfAKindPayConfigArray()[0].getLineBetMultiplierValue();
                if(newMultiplier > multiplier){
                    multiplier = newMultiplier;
                    matchedLinePatternObj = linePatternObj;
                }
            }
        }
        return matchedLinePatternObj;
    }

}
