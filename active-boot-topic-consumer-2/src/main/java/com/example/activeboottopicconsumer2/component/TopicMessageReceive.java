package com.example.activeboottopicconsumer2.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author LinYongJin
 * @date 2019/9/14 14:01
 */
@Component
public class TopicMessageReceive {

    @JmsListener(destination = "spring-boot-topic")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("consumer2收到的消息: " + textMessage.getText());
    }
}
