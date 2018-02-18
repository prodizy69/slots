package com.rss.pojo.modals;

import org.codehaus.jackson.map.util.JSONPObject;

/**

 */
public class ProducerPaylines {
    private String id;
    private String producerId;
    private JSONPObject payLines;
    private String name;
    private int columns;
    private int rows;

    public ProducerPaylines() {
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
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
        return "ProducerPaylines{" +
                "id='" + id + '\'' +
                ", producerId='" + producerId + '\'' +
                ", payLines=" + payLines +
                ", name='" + name + '\'' +
                ", columns=" + columns +
                ", rows=" + rows +
                '}';
    }
}
