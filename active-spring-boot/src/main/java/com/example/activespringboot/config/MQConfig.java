package com.example.activespringboot.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * @author LinYongJin
 * @date 2019/9/12 22:57
 */
@Configuration
@EnableJms
public class MQConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("spring-boot-queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("spring-boot-topic");
    }

    @Bean
    public RedeliveryPolicy redeliveryPolicy() {
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setMaximumRedeliveries(6);
        return redeliveryPolicy;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.0.108:61616");
        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy());
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory, Queue queue) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
        jmsTemplate.setDefaultDestination(queue);
        return jmsTemplate;
    }
}
