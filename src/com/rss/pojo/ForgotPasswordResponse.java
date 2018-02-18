package com.rss.pojo;

import com.rss.common.ErrorObj;
public class ForgotPasswordResponse extends BaseResponse
{
    public ForgotPasswordResponse(boolean isSuccess, ErrorObj error) {
        super(isSuccess, error);
    }
}
