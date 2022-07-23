package com.billing.installbillaccount.controller;

import com.billing.installbillaccount.entity.BillAccount;
import com.billing.installbillaccount.repository.BillAccountRepository;
import com.billing.installbillaccount.service.BillAccountService;
import com.blg.client.contract.SubscriptionProcessDtoCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BillAccountController {
    private BillAccountRepository billAccountRepository;
    @Autowired
    private BillAccountService billAccountService;

    @Autowired
    public BillAccountController(BillAccountRepository billAccountRepository) {
        this.billAccountRepository = billAccountRepository;
    }

    @PostMapping
    public ResponseEntity<?> createBillAccount(@RequestBody SubscriptionProcessDtoCopy subscriptionProcessDto) {
        return ResponseEntity.ok().body("OK");
    }

    @GetMapping
    public ResponseEntity<?> getAllData() {
        List<BillAccount> billAccounts = billAccountRepository.findAll();
        return ResponseEntity.ok().body(billAccounts);
    }
}
