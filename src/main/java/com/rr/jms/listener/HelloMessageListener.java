package com.rr.jms.listener;

import com.rr.jms.config.JmsConfig;
import com.rr.jms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage message) { // spring framework will automatically map the jms message to the object

        System.out.println("message received!!");
        System.out.println(message);

        //throw new RuntimeException("Message will be available in the queue for other/same listeners to read");
    }

    // if we want headers and the actual message, we can read them like this..
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers,
                       Message message){}
}
