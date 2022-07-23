package com.blg.client.event;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.contract.FeeDto;
import com.blg.client.contract.SubscriptionDto;

public class CreateBillAccountEvent {
    private Long customerId;
    private BillAccountDto billAccountDto;
    private SubscriptionDto subscriptionDto;
    private FeeDto feeDto;

    private CreateBillAccountEvent() {

    }

    public CreateBillAccountEvent(Long customerId, BillAccountDto billAccountDto, SubscriptionDto subscriptionDto, FeeDto feeDto) {
        this.customerId = customerId;
        this.billAccountDto = billAccountDto;
        this.subscriptionDto = subscriptionDto;
        this.feeDto = feeDto;
    }

    public BillAccountDto getBillAccountDto() {
        return billAccountDto;
    }

    public SubscriptionDto getSubscriptionDto() {
        return subscriptionDto;
    }

    public FeeDto getFeeDto() {
        return feeDto;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
