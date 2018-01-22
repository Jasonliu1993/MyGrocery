package com.grocery.services;

import com.grocery.dto.Email;
import com.grocery.serviceImpl.ActiveMQType;

public interface ActiveMQService {

    void sendMessage(ActiveMQType type, final String message);
    void sendMessage(ActiveMQType type, final Email message);

}
