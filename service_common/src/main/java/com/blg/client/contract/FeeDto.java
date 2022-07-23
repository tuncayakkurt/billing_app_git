package com.blg.client.contract;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class FeeDto {
    @Schema(title = "Fee Id", example = "1", required = true)
    @NotNull(message = "Fee Id cannot be null!")
    private int feeId;
    @Schema(title = "Reason Id", example = "1", required = true)
    @NotNull(message = "Reason Id cannot be null!")
    private int reasonId;

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
