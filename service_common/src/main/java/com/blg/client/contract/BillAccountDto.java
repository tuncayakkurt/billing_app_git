package com.blg.client.contract;

import com.blg.client.enums.BillAttribute;
import com.blg.client.enums.PhysicalInvoiceThemeTypes;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class BillAccountDto {
    @Email
    @Schema(title = "Email", example = "test@test.com", required = true)
    private String email;
    @Schema(title = "Bill Name", example = "test", required = true)
    @NotEmpty(message = "Bill Name cannot be empty!")
    private String billName;
    @Schema(title = "Physical Invoice Theme", example = "GALATASARAY", description = "If a physical invoice is requested, it should be sent.")
    private PhysicalInvoiceThemeTypes physicalInvoiceTheme;
    @Valid
    @NotNull(message = "Address object cannot be null!")
    private AddressDto addressDTO;
    @Schema(title = "Bill Cycle", example = "1", required = true)
    private int billCycle;
    @ArraySchema(schema = @Schema(title = "Bill Attributes", example = "PHYSICAL_INVOICE", required = true))
    @NotNull(message = "BillAttribute cannot be null!")
    private Set<BillAttribute> billAttributes;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public PhysicalInvoiceThemeTypes getPhysicalInvoiceTheme() {
        return physicalInvoiceTheme;
    }

    public void setPhysicalInvoiceTheme(PhysicalInvoiceThemeTypes physicalInvoiceTheme) {
        this.physicalInvoiceTheme = physicalInvoiceTheme;
    }

    public AddressDto getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDto addressDTO) {
        this.addressDTO = addressDTO;
    }

    public int getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(int billCycle) {
        this.billCycle = billCycle;
    }

    public Set<BillAttribute> getBillAttributes() {
        return billAttributes;
    }

    public void setBillAttributes(Set<BillAttribute> billAttributes) {
        this.billAttributes = billAttributes;
    }
}
