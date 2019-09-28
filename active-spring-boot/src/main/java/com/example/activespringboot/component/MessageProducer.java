package com.example.activespringboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @author LinYongJin
 * @date 2019/9/12 22:54
 */
@Component
public class MessageProducer {


    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void sendMessageToQueue() {
        jmsTemplate.convertAndSend(queue, "SpringBoot发送自队列的消息");
    }

//    @Scheduled(fixedDelay = 3000)
    public void scheduledSendMessage() {
        String message = UUID.randomUUID().toString().replace("-", "");
        System.out.println("发送消息: " + message);
        jmsTemplate.convertAndSend(queue, message);
    }
}
