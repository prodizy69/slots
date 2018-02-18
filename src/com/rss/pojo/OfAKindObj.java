package com.rss.pojo;

import java.util.ArrayList;
import java.util.Arrays;

public class OfAKindObj {
    private int lineBetMultiplierValue;
    private String symbol;
    private ArrayList<String> wilds;
    private int count;
    private int index;
    private String type;
    private MaxWild wildObj;
    private ArrayList indexes;
    private boolean used;
    private String hasFreespins;
    private float winAmount;
    private float totalBetMultiplierValue;
    private FreeSpinObj[] freeSpinsGameConfigArray;

    public OfAKindObj() {
    }

    public OfAKindObj(int lineBetMultiplierValue, int index) {
        this.lineBetMultiplierValue = lineBetMultiplierValue;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public FreeSpinObj[] getFreeSpinsGameConfigArray() {
        return freeSpinsGameConfigArray;
    }

    public void setFreeSpinsGameConfigArray(FreeSpinObj[] freeSpinsGameConfigArray) {
        this.freeSpinsGameConfigArray = freeSpinsGameConfigArray;
    }

    public String getHasFreespins() {
        return hasFreespins;
    }

    public void setHasFreespins(String hasFreespins) {
        this.hasFreespins = hasFreespins;
    }

    public float getTotalBetMultiplierValue() {
        return totalBetMultiplierValue;
    }

    public void setTotalBetMultiplierValue(float totalBetMultiplierValue) {
        this.totalBetMultiplierValue = totalBetMultiplierValue;
    }

    public int getLineBetMultiplierValue() {
        return lineBetMultiplierValue;
    }

    public void setLineBetMultiplierValue(int lineBetMultiplierValue) {
        this.lineBetMultiplierValue = lineBetMultiplierValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList getIndexes() {
        return indexes;
    }

    public void setIndexes(ArrayList indexes) {
        this.indexes = indexes;
    }

    public MaxWild getWildObj() {
        return wildObj;
    }

    public void setWildObj(MaxWild wildObj) {
        this.wildObj = wildObj;
    }

    public ArrayList<String> getWilds() {
        return wilds;
    }

    public void setWilds(ArrayList<String> wilds) {
        this.wilds = wilds;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public float getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(float winAmount) {
        this.winAmount = winAmount;
    }

    @Override
    public String toString() {
        return "OfAKindObj{" +
                "lineBetMultiplierValue=" + lineBetMultiplierValue +
                ", symbol='" + symbol + '\'' +
                ", wilds=" + wilds +
                ", count=" + count +
                ", index=" + index +
                ", type='" + type + '\'' +
                ", wildObj=" + wildObj +
                ", indexes=" + indexes +
                ", used=" + used +
                ", hasFreespins='" + hasFreespins + '\'' +
                ", winAmount=" + winAmount +
                ", totalBetMultiplierValue=" + totalBetMultiplierValue +
                ", freeSpinsGameConfigArray=" + Arrays.toString(freeSpinsGameConfigArray) +
                '}';
    }
}
