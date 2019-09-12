package com.example.activespringboot;

import com.example.activespringboot.component.MessageProducer;
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

    @Test
    public void contextLoads() {
        producer.sendMessageToQueue();
    }

}
