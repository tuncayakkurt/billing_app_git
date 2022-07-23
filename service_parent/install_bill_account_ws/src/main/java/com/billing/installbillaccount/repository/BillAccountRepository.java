package com.billing.installbillaccount.repository;

import com.billing.installbillaccount.entity.BillAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillAccountRepository extends JpaRepository<BillAccount, String> {
    Optional<BillAccount> findFirstByCustomerIdOrderByIdDesc(Long customerId);
}
