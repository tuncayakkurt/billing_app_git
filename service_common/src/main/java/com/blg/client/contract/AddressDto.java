package com.blg.client.contract;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDto {
    @NotNull(message = "City Name cannot be empty!")
    @Size(min = 2, max = 30, message = "City Name cannot be less than 2 characters and not more than 30 characters")
    @Schema(title = "City Name", example = "İstanbul", required = true, maximum = "30")
    private String city;
    @NotNull(message = "District Name cannot be empty!")
    @Size(min = 2, max = 50, message = "District Name cannot be less than 2 characters and not more than 50 characters")
    @Schema(title = "District Name", example = "Bakırköy", required = true, maximum = "50")
    private String district;
    @Size(min = 2, max = 50, message = "Neighbourhood Name cannot be less than 2 characters and not more than 100 characters")
    @NotEmpty(message = "Neighbourhood name cannot be empty!")
    @Schema(title = "Neighbourhood Name", example = "test Mahallesi", required = true, maximum = "100")
    private String neighbourhood;
    @NotEmpty(message = "Address cannot be empty!")
    @Schema(title = "Address", example = "234. Sokak test Apt. No: 1 Daire: 1", required = true)
    private String addressLine;
    @Size(min = 2, max = 10, message = "Post Code cannot be less than 2 characters and not more than 10 characters")
    @Schema(title = "Post Code", example = "34677", maximum = "10")
    private String postCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
