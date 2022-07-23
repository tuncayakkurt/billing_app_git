package com.billing.installcustomerws.entity.postgre;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customerSequence", allocationSize = 1)
    @GeneratedValue(generator = "customer_seq")
    @Column(name = "customer_id", unique = true)
    protected Long id;

    protected Long getId() {
        return id;
    }
}
