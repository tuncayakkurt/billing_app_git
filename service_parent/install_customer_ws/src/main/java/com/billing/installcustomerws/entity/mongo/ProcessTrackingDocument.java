package com.billing.installcustomerws.entity.mongo;

import com.billing.installcustomerws.enums.ProcessStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "process_tracking")
public class ProcessTrackingDocument {
    @Id
    private String customerId;
    private ProcessStatus status;
    private String description;

    private ProcessTrackingDocument() {
    }

    private ProcessTrackingDocument(String customerId, ProcessStatus status, String description) {
        this.customerId = customerId;
        this.status = status;
        this.description = description;
    }

    public static ProcessTrackingDocument create(String customerId) {
        return new ProcessTrackingDocument(customerId, ProcessStatus.PROCESSING, "");
    }

    public String getCustomerId() {
        return customerId;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
