package com.blg.client.contract;

import com.blg.client.payload.request.IndividualSubscriptionRequest;

public class SubscriptionProcessDto {
    private String customerId;
    private Long billAccountId;
    private String subscriptionId;

    public SubscriptionProcessDto(String customerId, Long billAccountId, String subscriptionId) {
        this.customerId = customerId;
        this.billAccountId = billAccountId;
        this.subscriptionId = subscriptionId;
    }

    public static SubscriptionProcessDto create(IndividualSubscriptionRequest request, String customerId) {
        return new SubscriptionProcessDto(customerId, null, null);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getBillAccountId() {
        return billAccountId;
    }

    public void setBillAccountId(Long billAccountId) {
        this.billAccountId = billAccountId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
