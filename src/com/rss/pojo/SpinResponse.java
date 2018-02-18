package com.rss.pojo;

import com.rss.common.ErrorObj;

public class SpinResponse extends BaseResponse
{

    private PayOutResponse spinOutCome;

    public SpinResponse(boolean success, ErrorObj error) {
        super(success, error);
    }

    public SpinResponse(boolean success, ErrorObj error, PayOutResponse spinOutCome) {
        super(success, error);
        this.spinOutCome = spinOutCome;
    }

    public PayOutResponse getSpinOutCome() {
        return spinOutCome;
    }

    public void setSpinOutCome(PayOutResponse spinOutCome) {
        this.spinOutCome = spinOutCome;
    }

    @Override
    public String toString() {
        return "SpinResponse{" +
                "spinOutCome=" + spinOutCome +
                '}';
    }
}
