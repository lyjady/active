package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author LinYongJin
 * @date 2019/9/12 22:32
 */
@Component
public class SpringTopicProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpringTopicProducer topicProducer = applicationContext.getBean("springTopicProducer", SpringTopicProducer.class);
        topicProducer.jmsTemplate.send(session -> session.createTextMessage("Spring发送主题的消息12345"));
        System.out.println("发送成功!!!");
    }
}
