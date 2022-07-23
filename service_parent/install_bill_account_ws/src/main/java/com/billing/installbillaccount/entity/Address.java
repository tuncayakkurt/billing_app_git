package com.billing.installbillaccount.entity;

import com.blg.client.contract.AddressDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(length = 30, nullable = false)
    private String city;
    @Column(length = 50, nullable = false)
    private String district;
    @Column(length = 100, nullable = false)
    private String neighbourhood;
    @Column(nullable = false)
    private String addressLine;
    @Column(length = 10)
    private String postCode;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonBackReference
    private BillAccount billAccount;

    private Address() {
    }

    private Address(String id, String city, String district, String neighbourhood, String addressLine, String postCode) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.neighbourhood = neighbourhood;
        this.addressLine = addressLine;
        this.postCode = postCode;
        this.billAccount = billAccount;
    }

    public static Address create(String id, AddressDto addressDto) {
        return new Address(id, addressDto.getCity(), addressDto.getDistrict(), addressDto.getNeighbourhood(),
                addressDto.getAddressLine(), addressDto.getPostCode());
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public String getPostCode() {
        return postCode;
    }
}
