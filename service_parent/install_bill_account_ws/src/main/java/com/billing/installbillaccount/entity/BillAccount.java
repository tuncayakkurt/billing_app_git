package com.billing.installbillaccount.entity;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.enums.BillAttribute;
import com.blg.client.enums.PhysicalInvoiceThemeTypes;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class BillAccount implements Serializable {
    @Id
    @Column(name = "bill_account_id", nullable = false)
    private String id;
    @Column(nullable = false)
    private Long customerId;
    @Column(nullable = false)
    private String billName;
    @CreatedDate
    @Column
    private LocalDateTime createdDate;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonManagedReference
    private Address address;

    @ElementCollection(targetClass = BillAttribute.class)
    @JoinTable(name = "bill_attributes", joinColumns = @JoinColumn(name = "bill_account_id"))
    @Column(name = "bill_attribute", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private Set<BillAttribute> billAttributes;

    @Enumerated(EnumType.STRING)
    @Column
    private PhysicalInvoiceThemeTypes physicalInvoiceTheme;

    @Column(nullable = false)
    private int billCycleId;
    @Column(nullable = false)
    private String email;

    private BillAccount() {
    }

    private BillAccount(String billAccountId, Long customerId, String billName, Address address, Set<BillAttribute> billAttributes,
                        PhysicalInvoiceThemeTypes physicalInvoiceTheme, int billCycleId, String email) {
        this.id = billAccountId;
        this.customerId = customerId;
        this.billName = billName;
        this.address = address;
        this.billAttributes = billAttributes;
        this.physicalInvoiceTheme = physicalInvoiceTheme;
        this.billCycleId = billCycleId;
        this.email = email;
    }

    public static BillAccount create(String billAccountId, Long customerId, BillAccountDto billAccountDto) {
        return new BillAccount(billAccountId, customerId, billAccountDto.getBillName(),
                Address.create(billAccountId, billAccountDto.getAddressDTO()), billAccountDto.getBillAttributes(),
                billAccountDto.getPhysicalInvoiceTheme(), billAccountDto.getBillCycle(), billAccountDto.getEmail());
    }

    public String getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getBillName() {
        return billName;
    }

    public Address getAddress() {
        return address;
    }

    public Set<BillAttribute> getBillAttributes() {
        return billAttributes;
    }

    public int getBillCycleId() {
        return billCycleId;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public PhysicalInvoiceThemeTypes getPhysicalInvoiceTheme() {
        return physicalInvoiceTheme;
    }

    @Override
    public String toString() {
        return "BillAccount{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", billName='" + billName + '\'' +
                ", createdDate=" + createdDate +
                ", address=" + address +
                ", billAttributes=" + billAttributes +
                ", billCycleId=" + billCycleId +
                ", email='" + email + '\'' +
                '}';
    }
}
