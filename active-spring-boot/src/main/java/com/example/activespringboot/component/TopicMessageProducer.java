package com.example.activespringboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @author LinYongJin
 * @date 2019/9/14 13:44
 */
@Component
public class TopicMessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

//    @Scheduled(fixedDelay = 3000)
    public void sendMessageTopic() {
        String message = UUID.randomUUID().toString().replace("-", "");
        System.out.println("发送的消息: " + message);
        jmsMessagingTemplate.convertAndSend(topic, "发送给队列的消息: " + message);
    }
}
