package com.rss.pojo;

public class ReelSet {
    private String reelSetName;
    private int[] reelStripLengths_Array;
    private String[][] reelStripsData_ArrayArray;

    public int[] getReelStripLengths_Array() {
        return reelStripLengths_Array;
    }

    public void setReelStripLengths_Array(int[] reelStripLengths_Array) {
        this.reelStripLengths_Array = reelStripLengths_Array;
    }

    public String[][] getReelStripsData_ArrayArray() {
        return reelStripsData_ArrayArray;
    }

    public void setReelStripsData_ArrayArray(String[][] reelStripsData_ArrayArray) {
        this.reelStripsData_ArrayArray = reelStripsData_ArrayArray;
    }

    public String getReelSetName() {
        return reelSetName;
    }

    public void setReelSetName(String reelSetName) {
        this.reelSetName = reelSetName;
    }
}
