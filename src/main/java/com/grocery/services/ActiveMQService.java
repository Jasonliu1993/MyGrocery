package com.grocery.services;

import com.grocery.dto.Email;

public interface ActiveMQService {

    void sendMessage(String type, final String message);
    void sendMessage(String type, final Email message);

}
