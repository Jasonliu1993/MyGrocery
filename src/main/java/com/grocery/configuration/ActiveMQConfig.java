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

    @Value("CustomProps.emailTopicName")
    private String topicName;

    @Value("CustomProps.queueName")
    private String queueName;

    @Bean
    public Topic getTopicDestination() {

        return new ActiveMQTopic(topicName);

    }

    @Bean
    public Queue getQueueDestination() {

        return new ActiveMQQueue(queueName);

    }

}
