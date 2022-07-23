package com.billing.installcustomerws.entity.mongo;

import com.blg.client.contract.SubscriptionDto;
import com.blg.client.enums.SubscriptionType;

public class SubscriptionDocument {
    private SubscriptionType subscriptionType;
    private int tariffId;
    private String resourceKey;
    private int languageId;
    private int currencyId;

    private SubscriptionDocument() {

    }

    private SubscriptionDocument(SubscriptionType subscriptionType, int tariffId, String resourceKey, int languageId,
                                 int currencyId) {
        this.subscriptionType = subscriptionType;
        this.tariffId = tariffId;
        this.resourceKey = resourceKey;
        this.languageId = languageId;
        this.currencyId = currencyId;
    }

    public static SubscriptionDocument create(SubscriptionDto subscription) {
        return new SubscriptionDocument(subscription.getSubscriptionType(), subscription.getTariffId(),
                subscription.getResourceKey(), subscription.getLanguageId(), subscription.getCurrencyId());
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public int getTariffId() {
        return tariffId;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public int getLanguageId() {
        return languageId;
    }

    public int getCurrencyId() {
        return currencyId;
    }
}
