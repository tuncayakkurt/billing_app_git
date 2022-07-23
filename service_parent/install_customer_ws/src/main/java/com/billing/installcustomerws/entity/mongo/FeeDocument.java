package com.billing.installcustomerws.entity.mongo;

import com.blg.client.contract.FeeDto;

public class FeeDocument {
    private int feeId;
    private int reasonId;

    private FeeDocument() {
    }

    private FeeDocument(int feeId, int reasonId) {
        this.feeId = feeId;
        this.reasonId = reasonId;
    }

    public static FeeDocument create(FeeDto fee) {
        return new FeeDocument(fee.getFeeId(), fee.getReasonId());
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }
}
