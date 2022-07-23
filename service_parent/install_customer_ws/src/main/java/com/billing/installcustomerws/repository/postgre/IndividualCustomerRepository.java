package com.billing.installcustomerws.repository.postgre;


import com.billing.installcustomerws.entity.postgre.IndividualCustomer;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCustomerRepository extends BaseRepository<IndividualCustomer, Long> {
}
