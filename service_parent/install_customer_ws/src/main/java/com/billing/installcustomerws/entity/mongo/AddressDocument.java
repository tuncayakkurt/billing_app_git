package com.billing.installcustomerws.entity.mongo;

import com.blg.client.contract.AddressDto;

public class AddressDocument {
    private String city;
    private String district;
    private String neighbourhood;
    private String addressLine;
    private String postCode;

    private AddressDocument() {
    }

    private AddressDocument(String city, String district, String neighbourhood, String addressLine, String postCode) {
        this.city = city;
        this.district = district;
        this.neighbourhood = neighbourhood;
        this.addressLine = addressLine;
        this.postCode = postCode;
    }

    public static AddressDocument create(AddressDto address) {
        return new AddressDocument(address.getCity(), address.getDistrict(), address.getNeighbourhood(),
                address.getAddressLine(), address.getPostCode());
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
