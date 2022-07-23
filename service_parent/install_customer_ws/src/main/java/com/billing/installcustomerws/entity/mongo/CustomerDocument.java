package com.billing.installcustomerws.entity.mongo;

import com.blg.client.enums.CustomerType;
import com.blg.client.payload.request.CorporateSubscriptionRequest;
import com.blg.client.payload.request.IndividualSubscriptionRequest;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Document(collection = "customer_store")
public class CustomerDocument {
    @Id
    private String id;
    private CustomerType customerType;
    private IndividualDocument individualCustomer;
    private CorporateDocument corporateCustomer;
    private BillAccountDocument billAccount;
    private SubscriptionDocument subscription;
    private FeeDocument fee;

    private CustomerDocument() {
    }

    private CustomerDocument(CustomerType customerType, IndividualDocument individualCustomer,
                             CorporateDocument corporateCustomer, BillAccountDocument billAccount,
                             SubscriptionDocument subscription, FeeDocument fee) {
        this.id = UUID.randomUUID().toString();
        this.customerType = customerType;
        this.individualCustomer = individualCustomer;
        this.corporateCustomer = corporateCustomer;
        this.billAccount = billAccount;
        this.subscription = subscription;
        this.fee = fee;
    }

    public static CustomerDocument create(IndividualSubscriptionRequest subscriptionRequest) {
        IndividualDocument individualDocument = IndividualDocument.create(subscriptionRequest.getCustomer());
        BillAccountDocument billAccount = BillAccountDocument.create(subscriptionRequest.getBillAccount());
        SubscriptionDocument subscription = SubscriptionDocument.create(subscriptionRequest.getSubscription());
        FeeDocument fee = FeeDocument.create(subscriptionRequest.getFeeDto());
        return new CustomerDocument(CustomerType.INDIVIDUAL, individualDocument, null, billAccount, subscription, fee);
    }

    public static CustomerDocument create(CorporateSubscriptionRequest subscriptionRequest) {
        CorporateDocument corporateDocument = CorporateDocument.create(subscriptionRequest.customer());
        BillAccountDocument billAccount = BillAccountDocument.create(subscriptionRequest.billAccount());
        SubscriptionDocument subscription = SubscriptionDocument.create(subscriptionRequest.subscription());
        FeeDocument fee = FeeDocument.create(subscriptionRequest.feeDto());
        return new CustomerDocument(CustomerType.CORPORATE, null, corporateDocument,
                billAccount, subscription, fee);
    }

    public String getId() {
        return id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public IndividualDocument getIndividualCustomer() {
        return individualCustomer;
    }

    public CorporateDocument getCorporateCustomer() {
        return corporateCustomer;
    }

    public BillAccountDocument getBillAccount() {
        return billAccount;
    }

    public SubscriptionDocument getSubscription() {
        return subscription;
    }

    public FeeDocument getFee() {
        return fee;
    }
}
