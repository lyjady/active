package com.example.listener;

import org.springframework.stereotype.Component;
import org.w3c.dom.Text;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author LinYongJin
 * @date 2019/9/12 22:37
 */
@Component
public class CustomMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
