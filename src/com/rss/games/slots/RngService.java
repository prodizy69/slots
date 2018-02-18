package com.rss.games.slots;

import java.security.SecureRandom;
import java.util.ArrayList;

public class RngService {
    private int[] reelStripLengths_Array;
    private String[][] reelStripsData_ArrayArray;
    private int numberOfRows;
    private Integer[] foOutPut;
    private SecureRandom secureRandom = new SecureRandom();

    public RngService(int[] reelStripLengths_Array) {
        this.reelStripLengths_Array = reelStripLengths_Array;
    }


    public RngService(int[] reelStripLengths_Array, String[][] reelStripsData_ArrayArray, int numberOfRows, Integer[] foOutPut) {
        this.reelStripLengths_Array = reelStripLengths_Array;
        this.reelStripsData_ArrayArray = reelStripsData_ArrayArray;
        this.numberOfRows = numberOfRows;
        this.foOutPut = foOutPut;
    }

    public String[][] generate(){
        Integer[] rngValues = this.generateRNG();
        String[][] rngOutPut = this.replaceWithSymbols(rngValues);
        return rngOutPut;
    }

    public Integer[] generateRNG(){
        if(this.foOutPut != null && this.foOutPut.length > 0){
            return this.foOutPut;
        }
        Integer[] rngOutPut = new Integer[this.reelStripLengths_Array.length];
        for(int index=0;index<this.reelStripLengths_Array.length;index++){
            int stripSize = this.reelStripLengths_Array[index];
            rngOutPut[index]=secureRandom.nextInt(stripSize);
        }
        return rngOutPut;
    }

    public String[][] replaceWithSymbols(Integer[] rngValues){
        String[][] rngOutPut = new String[this.numberOfRows][this.reelStripsData_ArrayArray.length];
        for(int stripNumber = 0;stripNumber<this.reelStripsData_ArrayArray.length;stripNumber++){
            int rngValue = rngValues[stripNumber];
            int maxSize = this.reelStripLengths_Array[stripNumber];
            String[] reelDataArray = this.reelStripsData_ArrayArray[stripNumber];
            for(int rowNumber=0;rowNumber<this.numberOfRows;rowNumber++) {
                String[] rowRecord = rngOutPut[rowNumber];
                if(rowRecord == null){
                    rngOutPut[rowNumber] = new String[this.reelStripsData_ArrayArray.length];
                }
                if(rngValue >= maxSize){
                    rngValue=0;
                }
                String symbolValue = reelDataArray[rngValue];
                rngOutPut[rowNumber][stripNumber]=symbolValue.toLowerCase();
                rngValue++;
            }
        }
        return rngOutPut;

    }
}
