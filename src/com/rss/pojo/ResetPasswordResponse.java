package com.rss.pojo;

import com.rss.common.ErrorObj;

public class ResetPasswordResponse extends BaseResponse
{
    public ResetPasswordResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }
}
