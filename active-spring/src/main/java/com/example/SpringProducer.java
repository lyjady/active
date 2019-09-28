package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * @author LinYongJin
 * @date 2019/9/12 21:43
 */
@Component
public class SpringProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpringProducer producer = applicationContext.getBean("springProducer", SpringProducer.class);
        producer.jmsTemplate.send(session -> session.createTextMessage("Spring发送的消息"));
        System.out.println("发送成功!!!");
    }
}
