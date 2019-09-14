package com.example.activeboottopicconsumer1.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * @author LinYongJin
 * @date 2019/9/14 14:01
 */
@Component
public class TopicMessageReceive {

    @JmsListener(destination = "spring-boot-topic")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("consumer1收到的消息: " + textMessage.getText());
    }
}
