package com.billing.installcustomerws.listener.event;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.contract.FeeDto;
import com.blg.client.contract.IndividualCustomerDto;
import com.blg.client.contract.SubscriptionDto;
import com.blg.client.payload.request.IndividualSubscriptionRequest;

public class CreateIndCustomerEvent {
    private IndividualCustomerDto individualCustomerDto;
    private BillAccountDto billAccountDto;
    private SubscriptionDto subscriptionDto;
    private FeeDto feeDto;

    private CreateIndCustomerEvent() {
    }

    private CreateIndCustomerEvent(IndividualCustomerDto individualCustomerDto,
                                   BillAccountDto billAccountDto, SubscriptionDto subscriptionDto, FeeDto feeDto) {
        this.individualCustomerDto = individualCustomerDto;
        this.billAccountDto = billAccountDto;
        this.subscriptionDto = subscriptionDto;
        this.feeDto = feeDto;
    }

    public static CreateIndCustomerEvent create(IndividualSubscriptionRequest subscriptionRequest) {
        return new CreateIndCustomerEvent(subscriptionRequest.getCustomer(), subscriptionRequest.getBillAccount(),
                subscriptionRequest.getSubscription(), subscriptionRequest.getFeeDto());
    }

    public IndividualCustomerDto getIndividualCustomerDto() {
        return individualCustomerDto;
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
}
