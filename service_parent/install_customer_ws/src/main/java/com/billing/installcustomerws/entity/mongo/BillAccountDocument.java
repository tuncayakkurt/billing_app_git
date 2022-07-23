package com.billing.installcustomerws.entity.mongo;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.enums.BillAttribute;
import com.blg.client.enums.PhysicalInvoiceThemeTypes;

import java.util.Set;

public class BillAccountDocument {
    private String email;
    private String billName;
    private AddressDocument address;
    private int billCycle;
    private Set<BillAttribute> billAttributes;
    private PhysicalInvoiceThemeTypes physicalInvoiceTheme;

    private BillAccountDocument() {
    }

    private BillAccountDocument(String email, String billName, AddressDocument address, int billCycle,
                                Set<BillAttribute> billAttributes, PhysicalInvoiceThemeTypes physicalInvoiceTheme) {
        this.email = email;
        this.billName = billName;
        this.address = address;
        this.billCycle = billCycle;
        this.billAttributes = billAttributes;
        this.physicalInvoiceTheme = physicalInvoiceTheme;
    }

    public static BillAccountDocument create(BillAccountDto billAccount) {
        AddressDocument address = AddressDocument.create(billAccount.getAddressDTO());
        return new BillAccountDocument(billAccount.getEmail(), billAccount.getBillName(), address,
                billAccount.getBillCycle(), billAccount.getBillAttributes(), billAccount.getPhysicalInvoiceTheme());
    }

    public String getEmail() {
        return email;
    }

    public String getBillName() {
        return billName;
    }

    public AddressDocument getAddress() {
        return address;
    }

    public int getBillCycle() {
        return billCycle;
    }

    public Set<BillAttribute> getBillAttributes() {
        return billAttributes;
    }

    public PhysicalInvoiceThemeTypes getPhysicalInvoiceTheme() {
        return physicalInvoiceTheme;
    }
}
