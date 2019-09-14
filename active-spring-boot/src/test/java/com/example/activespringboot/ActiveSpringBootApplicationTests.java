package com.example.activespringboot;

import com.example.activespringboot.component.MessageProducer;
import com.example.activespringboot.component.TopicMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveSpringBootApplicationTests {

    @Autowired
    private MessageProducer producer;

    @Autowired
    private TopicMessageProducer topic;

    @Test
    public void contextLoads() {
        producer.sendMessageToQueue();
    }

    @Test
    public void testSendTopicMessage() {
        topic.sendMessageTopic();
    }

}
