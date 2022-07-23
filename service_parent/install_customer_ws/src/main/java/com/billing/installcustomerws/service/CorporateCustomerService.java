package com.billing.installcustomerws.service;


import com.blg.client.payload.request.CorporateSubscriptionRequest;

public interface CorporateCustomerService {
    void createCustomer(CorporateSubscriptionRequest subscriptionRequest);

    boolean isThereAnyCustomer(String taxNumber);
}
