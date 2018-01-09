package com.grocery.messageHandler;

public enum MessageFromType {

    MESSAGE_BOARD_SUBREPLY("MessageBoardSubreply"),
    ;

    private String type;

    MessageFromType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
