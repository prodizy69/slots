package com.rss.pojo;

import com.rss.common.ErrorObj;

import java.io.Serializable;

public class BaseResponse implements Serializable {
    public boolean success =true;
    public ErrorObj error=null;

    public BaseResponse(boolean success, ErrorObj error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ErrorObj getError() {
        return error;
    }

    public void setError(ErrorObj error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", error=" + error +
                '}';
    }
}
