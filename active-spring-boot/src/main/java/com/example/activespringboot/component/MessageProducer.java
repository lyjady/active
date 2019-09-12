package com.example.activespringboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author LinYongJin
 * @date 2019/9/12 22:54
 */
@Component
public class MessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendMessageToQueue() {
        jmsMessagingTemplate.convertAndSend(queue, "SpringBoot发送自队列的消息");
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduledSendMessage() {
        jmsMessagingTemplate.convertAndSend(queue, "SpringBoot发送自队列的消息");
        System.out.println("发送消息!!!!");
    }
}
