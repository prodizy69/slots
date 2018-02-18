package com.rss.pojo;

public class FreeSpinObj {
    private String symbol;
    private int freeSpinsCount;
    private float lineWinMultiplierValue_duringFreeSpins;


    public int getFreeSpinsCount() {
        return freeSpinsCount;
    }

    public void setFreeSpinsCount(int freeSpinsCount) {
        this.freeSpinsCount = freeSpinsCount;
    }

    public float getLineWinMultiplierValue_duringFreeSpins() {
        return lineWinMultiplierValue_duringFreeSpins;
    }

    public void setLineWinMultiplierValue_duringFreeSpins(float lineWinMultiplierValue_duringFreeSpins) {
        this.lineWinMultiplierValue_duringFreeSpins = lineWinMultiplierValue_duringFreeSpins;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
