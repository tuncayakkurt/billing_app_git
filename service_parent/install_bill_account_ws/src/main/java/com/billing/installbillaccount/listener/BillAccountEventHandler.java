package com.billing.installbillaccount.listener;

import com.billing.installbillaccount.service.BillAccountService;
import com.blg.client.event.CreateBillAccountEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.billing.installbillaccount.config.KafkaConfiguration.BILL_ACCOUNT_GROUP_ID;
import static com.blg.client.constants.Topics.CREATE_BILL_ACCOUNT;

@Component
public class BillAccountEventHandler {
    private BillAccountService billAccountService;

    public BillAccountEventHandler(BillAccountService billAccountService) {
        this.billAccountService = billAccountService;
    }

    @KafkaListener(topics = CREATE_BILL_ACCOUNT, groupId = BILL_ACCOUNT_GROUP_ID)
    public void handler(CreateBillAccountEvent event) {
        billAccountService.create(event);
    }
}
