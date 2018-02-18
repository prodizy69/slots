package com.rss.util;

public class NodeObject {
    private String value;
    private String wild;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWild() {
        return wild;
    }

    public void setWild(String wild) {
        this.wild = wild;
    }

    @Override
    public String toString() {
        return "NodeObject{" +
                "value='" + value + '\'' +
                ", wild='" + wild + '\'' +
                '}';
    }
}
