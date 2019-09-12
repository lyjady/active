package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author LinYongJin
 * @date 2019/9/12 21:43
 */
@Component
public class SpringTopicConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpringTopicConsumer topicConsumer = applicationContext.getBean("springTopicConsumer", SpringTopicConsumer.class);
        String message = (String) topicConsumer.jmsTemplate.receiveAndConvert();
        System.out.println("从MQ获取到主题的信息: " + message);
    }
}
