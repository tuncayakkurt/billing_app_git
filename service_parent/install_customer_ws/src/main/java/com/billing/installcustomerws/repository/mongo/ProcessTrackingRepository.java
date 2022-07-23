package com.billing.installcustomerws.repository.mongo;

import com.billing.installcustomerws.entity.mongo.ProcessTrackingDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessTrackingRepository extends MongoRepository<ProcessTrackingDocument, Long> {
}
