package com.blg.client.enums;

public enum SubscriptionState {
    ACTIVE("act"), DEACTIVE("dct"), SUSPEND("spd"), REMOVED("rem");

    String value;

    SubscriptionState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
