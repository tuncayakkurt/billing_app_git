package com.blg.client.payload.request;

import com.blg.client.contract.BillAccountDto;
import com.blg.client.contract.CorporateCustomerDto;
import com.blg.client.contract.FeeDto;
import com.blg.client.contract.SubscriptionDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record CorporateSubscriptionRequest(
        @Valid
        @NotNull(message = "Customer object cannot be null!")
        CorporateCustomerDto customer,
        @Valid
        @NotNull(message = "Bill Account object cannot be null!")
        BillAccountDto billAccount,
        @Valid
        @NotNull(message = "Subscription object cannot be null!")
        SubscriptionDto subscription,
        @Valid
        @NotNull(message = "Fee object cannot be null!")
        FeeDto feeDto
) {
}
