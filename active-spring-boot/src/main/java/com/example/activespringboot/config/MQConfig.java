package com.example.activespringboot.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

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
}
