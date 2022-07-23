package com.billing.installcustomerws.service.impl;

import com.billing.installcustomerws.service.CorporateCustomerService;
import com.billing.installcustomerws.service.CustomerService;
import com.billing.installcustomerws.service.IndividualCustomerService;
import com.blg.client.payload.request.CorporateSubscriptionRequest;
import com.blg.client.payload.request.IndividualSubscriptionRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class CustomerServiceImpl implements CustomerService {
    private IndividualCustomerService individualCustomerService;
    private CorporateCustomerService corporateCustomerService;

    public CustomerServiceImpl(IndividualCustomerService individualCustomerService,
                               CorporateCustomerService corporateCustomerService) {
        this.individualCustomerService = individualCustomerService;
        this.corporateCustomerService = corporateCustomerService;
    }

    @Override
    public Boolean checkAndFetchCustomer(String identityOrTaxNumber) {
        CompletableFuture<Boolean> asyncInvCust = CompletableFuture.supplyAsync(() ->
                individualCustomerService.isThereAnyCustomer(identityOrTaxNumber)
        );
        CompletableFuture<Boolean> asyncCrpCust = CompletableFuture.supplyAsync(() ->
                corporateCustomerService.isThereAnyCustomer(identityOrTaxNumber)
        );
        CompletableFuture<Void> allOf = CompletableFuture.allOf(asyncInvCust, asyncCrpCust);
        allOf.join();

        try {
            boolean isThereAnyIndCustomer = asyncInvCust.get();
            boolean isThereAnyCrpCustomer = asyncCrpCust.get();
            if (isThereAnyCrpCustomer || isThereAnyIndCustomer) {
                return true;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void createIndividualCustomer(IndividualSubscriptionRequest subscriptionRequest) {
        individualCustomerService.createCustomer(subscriptionRequest);
    }

    @Override
    public void createCorporateCustomer(CorporateSubscriptionRequest subscriptionRequest) {
        corporateCustomerService.createCustomer(subscriptionRequest);
    }
}
