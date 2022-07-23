package com.blg.client.contract;

import com.blg.client.payload.request.CorporateSubscriptionRequest;
import com.blg.client.payload.request.IndividualSubscriptionRequest;

public class SubscriptionProcessDtoCopy {
    private String customerId;
    private Long billAccountId;
    private String subscriptionId;
    private BillAccountDto billAccountDto;
    private SubscriptionDto subscriptionDto;

    public SubscriptionProcessDtoCopy(String customerId, Long billAccountId, String subscriptionId,
                                      BillAccountDto billAccountDto, SubscriptionDto subscriptionDto) {
        this.customerId = customerId;
        this.billAccountId = billAccountId;
        this.subscriptionId = subscriptionId;
        this.billAccountDto = billAccountDto;
        this.subscriptionDto = subscriptionDto;
    }

    public static SubscriptionProcessDtoCopy create(IndividualSubscriptionRequest subscriptionRequest, String customerId) {
        return new SubscriptionProcessDtoCopy(customerId, null, null, subscriptionRequest.getBillAccount(),
                subscriptionRequest.getSubscription());
    }

    public static SubscriptionProcessDtoCopy create(CorporateSubscriptionRequest subscriptionRequest, String customerId) {
        return new SubscriptionProcessDtoCopy(customerId, null, null, subscriptionRequest.billAccount(),
                subscriptionRequest.subscription());
    }

    public SubscriptionProcessDtoCopy withBillAccountId(Long billAccountId) {
        return new SubscriptionProcessDtoCopy(customerId, billAccountId, null, billAccountDto, subscriptionDto);
    }

    public SubscriptionProcessDtoCopy withSubscriptionId(String subscriptionId) {
        return new SubscriptionProcessDtoCopy(customerId, billAccountId, subscriptionId, billAccountDto, subscriptionDto);
    }

    public SubscriptionProcessDtoCopy withBillAccountDto(BillAccountDto billAccountDto) {
        return new SubscriptionProcessDtoCopy(customerId, billAccountId, subscriptionId, billAccountDto, subscriptionDto);
    }

}
