package com.rss.pojo;

public class MaxWild {
    private String symbol;
    private Float multiplier;

    public MaxWild(String symbol, Float multiplier) {
        this.symbol = symbol;
        this.multiplier = multiplier;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Float multiplier) {
        this.multiplier = multiplier;
    }
}
