package com.billing.installcustomerws.entity.postgre;

import com.blg.client.contract.IndividualCustomerDto;
import com.blg.client.enums.CustomerAttribute;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class IndividualCustomer extends BaseEntity {
    @CreatedDate
    @Column
    private LocalDateTime createdDate;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(length = 11, nullable = false, unique = true)
    private String identityNumber;
    @Enumerated(EnumType.STRING)
    @Column
    private CustomerAttribute customerAttribute;

    private IndividualCustomer() {
    }

    private IndividualCustomer(String name, String lastName, String identityNumber,
                               CustomerAttribute customerAttribute) {
        this.name = name;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.customerAttribute = customerAttribute;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentificationNumber() {
        return identityNumber;
    }

    public Long getCustomerId() {
        return id;
    }

    public CustomerAttribute getCustomerAttribute() {
        return customerAttribute;
    }


    public static IndividualCustomer create(IndividualCustomerDto individualCustomerDto) {
        return new IndividualCustomer(individualCustomerDto.getName(), individualCustomerDto.getLastName(),
                individualCustomerDto.getIdentityNumber(), individualCustomerDto.getCustomerAttribute());
    }

    @Override
    public String toString() {
        return "IndividualCustomer{" +
                "  customerId='" + id + '\'' +
                "  createdDate=" + createdDate +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", customerAttribute=" + customerAttribute +
                '}';
    }
}
