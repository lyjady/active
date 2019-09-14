package com.example.activeboottopicconsumer2.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
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
}
