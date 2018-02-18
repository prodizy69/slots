package com.rss.pojo;

import com.rss.common.ErrorObj;

public class LogoutResponse extends BaseResponse {

    public LogoutResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }
}
