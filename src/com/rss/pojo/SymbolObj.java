package com.rss.pojo;

import org.codehaus.jackson.map.util.JSONPObject;

import java.util.ArrayList;

public class SymbolObj {
    private String symbolAlias;
    private String symbolType;
    private OfAKindObj[] ofAKindPayConfigArray;
    private PayConfig commonPayConfig;

    public String getSymbolAlias() {
        return symbolAlias;
    }

    public void setSymbolAlias(String symbolAlias) {
        this.symbolAlias = symbolAlias;
    }

    public String getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(String symbolType) {
        this.symbolType = symbolType;
    }

    public PayConfig getCommonPayConfig() {
        return commonPayConfig;
    }

    public void setCommonPayConfig(PayConfig commonPayConfig) {
        this.commonPayConfig = commonPayConfig;
    }

    public OfAKindObj[] getOfAKindPayConfigArray() {
        return ofAKindPayConfigArray;
    }

    public void setOfAKindPayConfigArray(OfAKindObj[] ofAKindPayConfigArray) {
        this.ofAKindPayConfigArray = ofAKindPayConfigArray;
    }
}
