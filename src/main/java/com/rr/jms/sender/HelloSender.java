package com.rr.jms.sender;

import com.rr.jms.config.JmsConfig;
import com.rr.jms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000) // task executor defined in TaskConfig takes care of scheduling
    public void sendMessage() {
        System.out.println("sending a message..");

        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message); // this makes use of the messageConverter() in JmsConfig

        System.out.println("message sent!");
    }
}
