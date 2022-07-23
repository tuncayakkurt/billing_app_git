package com.blg.client.event;

import com.blg.client.contract.FeeDto;
import com.blg.client.contract.SubscriptionDto;

public class CreateSubscriptionEvent {
    private SubscriptionDto subscriptionDto;
    private FeeDto feeDto;

    public SubscriptionDto getSubscriptionDto() {
        return subscriptionDto;
    }

    public FeeDto getFeeDto() {
        return feeDto;
    }
}
