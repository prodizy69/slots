package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

public class SuggestedPayLines {
    private String id;
    private JSONPObject payLines;
    private String name;
    private int columns;
    private int rows;

    public SuggestedPayLines() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONPObject getPayLines() {
        return payLines;
    }

    public void setPayLines(JSONPObject payLines) {
        this.payLines = payLines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "SuggestedPayLines{" +
                "id='" + id + '\'' +
                ", payLines=" + payLines +
                ", name='" + name + '\'' +
                ", columns=" + columns +
                ", rows=" + rows +
                '}';
    }
}
