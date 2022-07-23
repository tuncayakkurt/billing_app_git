package com.billing.installcustomerws.enums;

import org.springframework.http.HttpStatus;

public enum CustomHttpStatus {
    METHOD_ARGUMENT_NOT_VALID(600, HttpStatus.Series.CLIENT_ERROR, "Method argument not valid"),
    CUSTOMER_ALREADY_EXISTS(601, HttpStatus.Series.CLIENT_ERROR, "Customer already exists");
    private int value;
    private final HttpStatus.Series series;
    private final String reasonPhrase;

    CustomHttpStatus(int value, HttpStatus.Series series, String reasonPhrase) {
        this.value = value;
        this.series = series;
        this.reasonPhrase = reasonPhrase;
    }

    public int status() {
        return this.value;
    }

    public HttpStatus.Series series() {
        return this.series;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
