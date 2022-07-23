package com.blg.client.contract;

import com.blg.client.enums.CustomerAttribute;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class IndividualCustomerDto {
    @Schema(title = "Name", example = "testName", required = true)
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    @Schema(title = "Lastname", example = "testLastName", required = true)
    @NotEmpty(message = "Lastname cannot be empty!")
    private String lastName;
    @Schema(title = "Identification Number", example = "11111111110", minimum = "11", maximum = "11", required = true)
    @Size(min = 11, max = 11, message = "Identification number must be 11 characters")
    @NotEmpty(message = "Identification Number cannot be empty!")
    private String identityNumber;
    @Schema(title = "Customer Attribute", example = "NORMAL", required = true)
    @NotNull(message = "Customer Attribute cannot be null!")
    private CustomerAttribute customerAttribute;

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
