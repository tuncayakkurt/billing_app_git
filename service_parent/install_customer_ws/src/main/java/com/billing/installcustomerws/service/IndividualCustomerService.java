package com.billing.installcustomerws.service;


import com.blg.client.payload.request.IndividualSubscriptionRequest;

public interface IndividualCustomerService {
    void createCustomer(IndividualSubscriptionRequest subscriptionRequest);

    boolean isThereAnyCustomer(String identityNumber);

}
