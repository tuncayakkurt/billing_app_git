package com.billing.installcustomerws.service;

import com.blg.client.payload.request.CorporateSubscriptionRequest;
import com.blg.client.payload.request.IndividualSubscriptionRequest;

public interface CustomerService {
    Boolean checkAndFetchCustomer(String identityOrTaxNumber);

    void createIndividualCustomer(IndividualSubscriptionRequest subscriptionRequest);

    void createCorporateCustomer(CorporateSubscriptionRequest subscriptionRequest);
}
