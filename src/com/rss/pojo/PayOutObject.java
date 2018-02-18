package com.rss.pojo;

import java.util.ArrayList;

public class PayOutObject {
    private float winAmount;
    private float totalPayOut;
    private int betLineIndex;
    private ArrayList<OfAKindObj> windowMatrix;
    private boolean linePattern;
    private LinePatternObj linePatternUsed;
    private float payOutPerPayLine;
    private float scatterWinAmount;
    private float freeSpinWinAmount;

    public float getFreeSpinWinAmount() {
        return freeSpinWinAmount;
    }

    public void setFreeSpinWinAmount(float freeSpinWinAmount) {
        this.freeSpinWinAmount = freeSpinWinAmount;
    }

    public float getScatterWinAmount() {
        return scatterWinAmount;
    }

    public void setScatterWinAmount(float scatterWinAmount) {
        this.scatterWinAmount = scatterWinAmount;
    }

    public float getTotalPayOut() {
        return totalPayOut;
    }

    public void setTotalPayOut(float totalPayOut) {
        this.totalPayOut = totalPayOut;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
    }

    public int getBetLineIndex() {
        return betLineIndex;
    }

    public void setBetLineIndex(int betLineIndex) {
        this.betLineIndex = betLineIndex;
    }

    public ArrayList<OfAKindObj> getWindowMatrix() {
        return windowMatrix;
    }

    public void setWindowMatrix(ArrayList<OfAKindObj> windowMatrix) {
        this.windowMatrix = windowMatrix;
    }

    public boolean isLinePattern() {
        return linePattern;
    }

    public void setLinePattern(boolean linePattern) {
        this.linePattern = linePattern;
    }

    public LinePatternObj getLinePatternUsed() {
        return linePatternUsed;
    }

    public void setLinePatternUsed(LinePatternObj linePatternUsed) {
        this.linePatternUsed = linePatternUsed;
    }

    public float getPayOutPerPayLine() {
        return payOutPerPayLine;
    }

    public void setPayOutPerPayLine(float payOutPerPayLine) {
        this.payOutPerPayLine = payOutPerPayLine;
    }
}
