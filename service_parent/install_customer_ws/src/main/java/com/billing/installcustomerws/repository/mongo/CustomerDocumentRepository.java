package com.billing.installcustomerws.repository.mongo;

import com.billing.installcustomerws.entity.mongo.CustomerDocument;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDocumentRepository extends MongoRepository<CustomerDocument, Long> {
    @ExistsQuery("{ 'individualCustomer.identityNumber': ?0}")
    boolean existByIdentityNumber(String identityNumber);

    @ExistsQuery("{ 'corporateCustomer.taxNumber': ?0}")
    boolean existByTaxNumber(String taxNumber);
}
