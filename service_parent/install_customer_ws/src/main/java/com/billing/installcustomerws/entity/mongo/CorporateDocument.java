package com.billing.installcustomerws.entity.mongo;

import com.blg.client.contract.CorporateCustomerDto;

public class CorporateDocument {
    private String companyName;
    private String taxNumber;

    private CorporateDocument() {
    }

    private CorporateDocument(String companyName, String taxNumber) {
        this.companyName = companyName;
        this.taxNumber = taxNumber;
    }

    public static CorporateDocument create(CorporateCustomerDto customer) {
        return new CorporateDocument(customer.getCompanyName(), customer.getTaxNumber());
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }
}
