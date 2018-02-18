package com.rss.pojo;

public class PlayLines {
    private boolean allWaysSlots;

    private int[][][] windowMatrix_Array;

    public int[][][] getWindowMatrix_Array() {
        return windowMatrix_Array;
    }

    public void setWindowMatrix_Array(int[][][] windowMatrix_Array) {
        this.windowMatrix_Array = windowMatrix_Array;
    }

    public boolean isAllWaysSlots() {
        return allWaysSlots;
    }

    public void setAllWaysSlots(boolean allWaysSlots) {
        this.allWaysSlots = allWaysSlots;
    }
}
