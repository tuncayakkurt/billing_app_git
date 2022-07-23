package com.blg.client.payload.request;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.contract.FeeDto;
import com.blg.client.contract.IndividualCustomerDto;
import com.blg.client.contract.SubscriptionDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class IndividualSubscriptionRequest {
    @Valid
    @NotNull(message = "Address object cannot be null!")
    private IndividualCustomerDto customer;
    @Valid
    @NotNull(message = "BillAccount object cannot be null!")
    private BillAccountDto billAccount;
    @Valid
    @NotNull(message = "Subscription object cannot be null!")
    private SubscriptionDto subscription;
    @Valid
    @NotNull(message = "Fee object cannot be null!")
    private FeeDto feeDto;

    public IndividualCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(IndividualCustomerDto customer) {
        this.customer = customer;
    }

    public BillAccountDto getBillAccount() {
        return billAccount;
    }

    public void setBillAccount(BillAccountDto billAccount) {
        this.billAccount = billAccount;
    }

    public SubscriptionDto getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionDto subscription) {
        this.subscription = subscription;
    }

    public FeeDto getFeeDto() {
        return feeDto;
    }

    public void setFeeDto(FeeDto feeDto) {
        this.feeDto = feeDto;
    }
}
