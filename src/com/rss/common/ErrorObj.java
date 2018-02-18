package com.rss.common;

public class ErrorObj {
    public String code;
    public String description;

    public ErrorObj(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorObj{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
