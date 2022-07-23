package com.billing.installcustomerws.service.impl;

import com.billing.installcustomerws.repository.postgre.CorporateCustomerRepository;
import com.billing.installcustomerws.service.CorporateCustomerService;
import com.billing.installcustomerws.service.base.BaseService;
import com.blg.client.payload.request.CorporateSubscriptionRequest;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerServiceImpl extends BaseService implements CorporateCustomerService {
    private CorporateCustomerRepository customerRepository;

    public CorporateCustomerServiceImpl(CorporateCustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void createCustomer(CorporateSubscriptionRequest subscriptionRequest) {

    }

    @Override
    public boolean isThereAnyCustomer(String taxNumber) {
        return false;
    }
}
