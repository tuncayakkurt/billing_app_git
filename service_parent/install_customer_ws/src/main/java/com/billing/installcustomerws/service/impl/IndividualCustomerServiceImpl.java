package com.billing.installcustomerws.service.impl;

import com.billing.installcustomerws.entity.mongo.CustomerDocument;
import com.billing.installcustomerws.exceptions.CustomerAlreadyExistsException;
import com.billing.installcustomerws.listener.event.CreateIndCustomerEvent;
import com.billing.installcustomerws.repository.mongo.CustomerDocumentRepository;
import com.billing.installcustomerws.repository.postgre.IndividualCustomerRepository;
import com.billing.installcustomerws.service.IndividualCustomerService;
import com.billing.installcustomerws.service.base.BaseService;
import com.blg.client.payload.request.IndividualSubscriptionRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.billing.installcustomerws.constants.KafkaConstants.CREATE_INV_CUSTOMER;

@Service
public class IndividualCustomerServiceImpl extends BaseService implements IndividualCustomerService {
    private IndividualCustomerRepository customerRepository;
    private CustomerDocumentRepository customerDocumentRepository;
    private final KafkaTemplate kafkaTemplate;


    public IndividualCustomerServiceImpl(IndividualCustomerRepository customerRepository,
                                         CustomerDocumentRepository customerDocumentRepository,
                                         KafkaTemplate kafkaTemplate) {
        this.customerRepository = customerRepository;
        this.customerDocumentRepository = customerDocumentRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void createCustomer(IndividualSubscriptionRequest subscriptionRequest) {
        CreateIndCustomerEvent event = CreateIndCustomerEvent.create(subscriptionRequest);
        CustomerDocument customerDoc = CustomerDocument.create(subscriptionRequest);
        boolean isThereAnyCustomer = isThereAnyCustomer(subscriptionRequest.getCustomer().getIdentityNumber());
        if (isThereAnyCustomer) {
            throw new CustomerAlreadyExistsException(String.format("Customer already exists. IdentityNumber: %s",
                    subscriptionRequest.getCustomer().getIdentityNumber()));
        }
        customerDocumentRepository.save(customerDoc);
        kafkaTemplate.send(CREATE_INV_CUSTOMER, event);
    }

    @Override
    public boolean isThereAnyCustomer(String identityNumber) {
        return customerDocumentRepository.existByIdentityNumber(identityNumber);
    }
}
