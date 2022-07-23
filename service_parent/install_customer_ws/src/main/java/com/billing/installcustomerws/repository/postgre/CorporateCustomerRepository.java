package com.billing.installcustomerws.repository.postgre;

import com.billing.installcustomerws.entity.postgre.CorporateCustomer;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends BaseRepository<CorporateCustomer, Long> {
}
