package com.example.activespringboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Queue;

/**
 * @author LinYongJin
 * @date 2019/9/14 13:36
 */
@Component
public class MessageConsumer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    //MessageListener监听器监听队列
    @JmsListener(destination = "spring-boot-queue")
    public void receiveMessage(TextMessage textMessage) throws JMSException {
        System.out.println("监听器监听到的消息: " + textMessage.getText());
    }
}
