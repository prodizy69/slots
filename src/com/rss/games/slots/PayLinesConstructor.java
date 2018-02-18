package com.rss.games.slots;

import com.rss.common.Constants;
import com.rss.pojo.GameConfig;
import com.rss.pojo.PlayLines;

import java.util.ArrayList;

public class PayLinesConstructor {
    private GameConfig gameConfig;
    private String[][] rngOutPut;
    private int[][][] play_linesArray;

    public PayLinesConstructor(GameConfig gameConfig, String[][] rngOutPut, int[][][] play_linesArray) {
        this.gameConfig = gameConfig;
        this.rngOutPut = rngOutPut;
        this.play_linesArray = play_linesArray;
    }

    public String[][] construct(){
        ArrayList play_linesWithRNGOutPut = new ArrayList();
        for(int payLineNumber = 0; payLineNumber < this.play_linesArray.length; payLineNumber++){
            int[][] payLineWindow = this.play_linesArray[payLineNumber];
            ArrayList payLineWithRNGOutPut = new ArrayList();
            for(int rowNumber = 0; rowNumber<payLineWindow.length;rowNumber++){
                int[] rowRecord = payLineWindow[rowNumber];
                for(int columnNumber = 0; columnNumber < rowRecord.length; columnNumber++){
                    int isPartOfPayLine = rowRecord[columnNumber];
                    if(isPartOfPayLine == Constants.WINDOW_PAY_LINE){
                        payLineWithRNGOutPut.add(columnNumber,this.rngOutPut[rowNumber][columnNumber]);
                    }
                }
            }
            play_linesWithRNGOutPut.add(payLineWithRNGOutPut.toArray(new String[payLineWithRNGOutPut.size()]));
        }
        return (String[][]) play_linesWithRNGOutPut.toArray(new String[play_linesWithRNGOutPut.size()][]);
    }
}
