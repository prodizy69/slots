package com.rss.pojo;

public class SpecialWildObj {
    private int rowIndex;
    private int colIndex;
    private int stickyCount;
    private String specialType;
    private String specialWildTypeOrder;
    private String symbol;
    private boolean usedInCurrentRun;

    public SpecialWildObj(int rowIndex, int colIndex, int stickyCount, String specialType, String specialWildTypeOrder, String symbol) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.stickyCount = stickyCount;
        this.specialType = specialType;
        this.specialWildTypeOrder = specialWildTypeOrder;
        this.symbol = symbol;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    public int getStickyCount() {
        return stickyCount;
    }

    public void setStickyCount(int stickyCount) {
        this.stickyCount = stickyCount;
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
    }

    public String getSpecialWildTypeOrder() {
        return specialWildTypeOrder;
    }

    public void setSpecialWildTypeOrder(String specialWildTypeOrder) {
        this.specialWildTypeOrder = specialWildTypeOrder;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isUsedInCurrentRun() {
        return usedInCurrentRun;
    }

    public void setUsedInCurrentRun(boolean usedInCurrentRun) {
        this.usedInCurrentRun = usedInCurrentRun;
    }
}
