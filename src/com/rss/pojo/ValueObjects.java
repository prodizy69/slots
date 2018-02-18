package com.rss.pojo;

import java.io.Serializable;

public class ValueObjects implements Serializable {
    private int index=0;
    private String dataType;
    private Object value;

    public ValueObjects(int index, String dataType, Object value) {
        this.index = index;
        this.dataType = dataType;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueObjects{" +
                "index=" + index +
                ", dataType='" + dataType + '\'' +
                ", value=" + value +
                '}';
    }
}
