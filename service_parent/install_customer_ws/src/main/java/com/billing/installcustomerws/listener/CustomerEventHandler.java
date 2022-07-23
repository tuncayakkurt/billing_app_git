package com.billing.installcustomerws.listener;

import com.billing.installcustomerws.entity.postgre.IndividualCustomer;
import com.billing.installcustomerws.listener.event.CreateCrpCustomerEvent;
import com.billing.installcustomerws.listener.event.CreateIndCustomerEvent;
import com.billing.installcustomerws.repository.mongo.ProcessTrackingRepository;
import com.billing.installcustomerws.repository.postgre.CorporateCustomerRepository;
import com.billing.installcustomerws.repository.postgre.IndividualCustomerRepository;
import com.blg.client.event.CreateBillAccountEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.billing.installcustomerws.constants.KafkaConstants.*;
import static com.blg.client.constants.Topics.CREATE_BILL_ACCOUNT;

@Component
public class CustomerEventHandler {
    private KafkaTemplate kafkaTemplate;

    private ProcessTrackingRepository processTrackingRepository;
    private IndividualCustomerRepository individualRepository;
    private CorporateCustomerRepository customerRepository;

    public CustomerEventHandler(KafkaTemplate kafkaTemplate,
                                ProcessTrackingRepository processTrackingRepository, IndividualCustomerRepository individualRepository,
                                CorporateCustomerRepository customerRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.processTrackingRepository = processTrackingRepository;
        this.individualRepository = individualRepository;
        this.customerRepository = customerRepository;
    }

    @KafkaListener(topics = CREATE_INV_CUSTOMER, groupId = CUSTOMER_GROUP_ID)
    public void handle(@Payload CreateIndCustomerEvent event) {
        IndividualCustomer customer = IndividualCustomer.create(event.getIndividualCustomerDto());
        IndividualCustomer savedCustomer = individualRepository.save(customer);
        //ProcessTrackingDocument processTracking = ProcessTrackingDocument.create(savedCustomer.getCustomerId());
        CreateBillAccountEvent createBillAccountEvent = new CreateBillAccountEvent(savedCustomer.getCustomerId(),
                event.getBillAccountDto(), event.getSubscriptionDto(), event.getFeeDto());
        kafkaTemplate.send(CREATE_BILL_ACCOUNT, createBillAccountEvent);
        //processTrackingRepository.save(processTracking);

    }

    @KafkaListener(topics = CREATE_CRP_CUSTOMER, groupId = CUSTOMER_GROUP_ID)
    public void handle(@Payload CreateCrpCustomerEvent event) {
        System.out.println("test crp");

    }
}
