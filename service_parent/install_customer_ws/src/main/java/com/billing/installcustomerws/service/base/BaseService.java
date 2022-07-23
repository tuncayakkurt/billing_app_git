package com.billing.installcustomerws.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Long creteCustomerId(Long id) {
        return id + 1;
    }
}
