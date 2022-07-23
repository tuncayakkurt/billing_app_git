package com.billing.installcustomerws.listener.event;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.contract.CorporateCustomerDto;
import com.blg.client.contract.FeeDto;
import com.blg.client.contract.SubscriptionDto;

public class CreateCrpCustomerEvent {
    private Long customerId;
    private CorporateCustomerDto corporateCustomerDto;
    private BillAccountDto billAccountDto;
    private SubscriptionDto subscriptionDto;
    private FeeDto feeDto;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public CorporateCustomerDto getCorporateCustomerDto() {
        return corporateCustomerDto;
    }

    public void setCorporateCustomerDto(CorporateCustomerDto corporateCustomerDto) {
        this.corporateCustomerDto = corporateCustomerDto;
    }

    public BillAccountDto getBillAccountDto() {
        return billAccountDto;
    }

    public void setBillAccountDto(BillAccountDto billAccountDto) {
        this.billAccountDto = billAccountDto;
    }

    public SubscriptionDto getSubscriptionDto() {
        return subscriptionDto;
    }

    public void setSubscriptionDto(SubscriptionDto subscriptionDto) {
        this.subscriptionDto = subscriptionDto;
    }

    public FeeDto getFeeDto() {
        return feeDto;
    }

    public void setFeeDto(FeeDto feeDto) {
        this.feeDto = feeDto;
    }
}
