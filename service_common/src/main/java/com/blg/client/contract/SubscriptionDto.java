package com.blg.client.contract;

import com.blg.client.enums.SubscriptionType;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubscriptionDto {
    @Schema(title = "Subscription Type", example = "WIRELESS", required = true)
    private SubscriptionType subscriptionType;
    @Schema(title = "Tariff Id", example = "1", required = true)
    @NotNull(message = "Tariff Id cannot be null!")
    private int tariffId;
    @Schema(title = "Resource Key", example = "5553332211", required = true,
            description = "Phone number or internet line number ('233543323') must be entered")
    @NotEmpty(message = "Resource Key cannot be empty!")
    private String resourceKey;
    @Schema(title = "Language Id", example = "1", required = true)
    @NotNull(message = "Language Id cannot be null!")
    private int languageId;
    @Schema(title = "Currency Id", example = "1", required = true)
    @NotNull(message = "Currency Id cannot be null!")
    private int currencyId;

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }
}
