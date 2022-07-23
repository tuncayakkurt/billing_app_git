package com.billing.installcustomerws.entity.postgre;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CorporateCustomer extends BaseEntity {
    @CreatedDate
    @Column
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String companyName;
    @Column(unique = true)
    private String taxNumber;

    private CorporateCustomer() {
    }

    private CorporateCustomer(String companyName, String taxNumber) {
        this.companyName = companyName;
        this.taxNumber = taxNumber;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public Long getCustomerId() {
        return id;
    }

//    public static CorporateCustomer create(CorporateCustomerDto corporateCustomerDto) {
//        return new CorporateCustomer(corporateCustomerDto.getCompanyName(),
//                corporateCustomerDto.getTaxNumber());
//    }

    @Override
    public String toString() {
        return "CorporateCustomer{" +
                "  customerId='" + id + '\'' +
                "  createdDate=" + createdDate +
                ", companyName='" + companyName + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                '}';
    }
}
