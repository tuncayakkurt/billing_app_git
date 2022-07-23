package com.billing.installbillaccount.service;

import com.blg.client.event.CreateBillAccountEvent;

public interface BillAccountService {
    void create(CreateBillAccountEvent event);
}
