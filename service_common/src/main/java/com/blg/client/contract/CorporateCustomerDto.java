package com.blg.client.contract;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public class CorporateCustomerDto {
    @Schema(title = "Company Name", example = "testName Ltd şti.", required = true)
    @NotEmpty(message = "Company Name cannot be empty!")
    private String companyName;
    @Schema(title = "Tax Number", example = "2343523454234", required = true)
    @NotEmpty(message = "Tax number cannot be empty!")
    private String taxNumber;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }
}
