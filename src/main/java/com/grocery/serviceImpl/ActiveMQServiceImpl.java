package com.grocery.serviceImpl;

import com.grocery.dto.Email;
import com.grocery.services.ActiveMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class ActiveMQServiceImpl implements ActiveMQService {

    @Autowired
    private Topic topic;

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendMessage(ActiveMQType type, final String message) {
        Destination destination = null;

        switch (type.getType()) {
            case "topic":
                destination = topic;
                break;
            case "queue":
                destination = queue;
                break;
        }
        jmsTemplate.send(destination, session -> {
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;
        });
    }

    @Override
    public void sendMessage(ActiveMQType type, final Email message) {
        Destination destination = null;

        switch (type.getType()) {
            case "topic":
                destination = topic;
                break;
            case "queue":
                destination = queue;
                break;
        }
        jmsTemplate.send(destination, session -> {
            ObjectMessage objectMessage = session.createObjectMessage(message);
            return objectMessage;
        });
    }
}
