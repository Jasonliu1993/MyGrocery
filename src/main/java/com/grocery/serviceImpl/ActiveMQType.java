package com.grocery.serviceImpl;

public enum ActiveMQType {
    QUEUE("queue"),
    TOPIC("topic"),
    ;
    ActiveMQType(String type) {
        this.type =type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
