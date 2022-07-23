package com.billing.installcustomerws.entity.mongo;

import com.blg.client.contract.IndividualCustomerDto;
import com.blg.client.enums.CustomerAttribute;

public class IndividualDocument {
    private String name;
    private String lastName;
    private String identityNumber;
    private CustomerAttribute customerAttribute;

    private IndividualDocument() {
    }

    private IndividualDocument(String name, String lastName, String identityNumber, CustomerAttribute customerAttribute) {
        this.name = name;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.customerAttribute = customerAttribute;
    }

    public static IndividualDocument create(IndividualCustomerDto customer) {
        return new IndividualDocument(customer.getName(), customer.getLastName(), customer.getIdentityNumber(),
                customer.getCustomerAttribute());
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public CustomerAttribute getCustomerAttribute() {
        return customerAttribute;
    }
}
