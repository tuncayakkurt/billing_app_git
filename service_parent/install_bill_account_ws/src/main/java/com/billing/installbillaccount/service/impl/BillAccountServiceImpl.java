package com.billing.installbillaccount.service.impl;

import com.billing.installbillaccount.entity.BillAccount;
import com.billing.installbillaccount.repository.BillAccountRepository;
import com.billing.installbillaccount.service.BillAccountService;
import com.blg.client.event.CreateBillAccountEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillAccountServiceImpl implements BillAccountService {
    private BillAccountRepository billAccountRepository;

    @Autowired
    public BillAccountServiceImpl(BillAccountRepository billAccountRepository) {
        this.billAccountRepository = billAccountRepository;
    }

    @Override
    public void create(CreateBillAccountEvent event) {
        String billAccountId = createBillAccountId(event.getCustomerId());
        BillAccount billAccount = BillAccount.create(billAccountId, event.getCustomerId(), event.getBillAccountDto());
        billAccountRepository.save(billAccount);
    }

    private String createBillAccountId(Long customerId) {
        Long billAccountId = 1l;
        Optional<BillAccount> billAccount = billAccountRepository.findFirstByCustomerIdOrderByIdDesc(customerId);
        if (billAccount.isPresent()) {
            billAccountId = Long.parseLong(billAccount.get().getId()) + 1;
        }
        return String.format("%s-%s", customerId, billAccountId);
    }
}
