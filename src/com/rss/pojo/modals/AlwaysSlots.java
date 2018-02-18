package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

/**

 */
public class AlwaysSlots {
    private int id;
    private JSONPObject playLines;
    private int columns;
    private int rows;

    public AlwaysSlots() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONPObject getPlayLines() {
        return playLines;
    }

    public void setPlayLines(JSONPObject playLines) {
        this.playLines = playLines;
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
        return "AlwaysSlots{" +
                "id=" + id +
                ", playLines=" + playLines +
                ", columns=" + columns +
                ", rows=" + rows +
                '}';
    }
}
