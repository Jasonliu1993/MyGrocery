package com.grocery.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {

    @Value("${CustomProps.emailTopicText}")
    private String emailTopicText;

    @Value("${CustomProps.emailTopicObject}")
    private String emailTopicObject;

    @Value("${CustomProps.emailQueueName}")
    private String emailQueueName;

    @Value("${CustomProps.emailQueueObject}")
    private String emailQueueObject;

    @Bean
    public Topic getTopicDestination() {

        return new ActiveMQTopic(emailTopicText);

    }

    @Bean
    public Queue getQueueDestination() {

        return new ActiveMQQueue(emailQueueName);

    }

}
