package com.example.rabbitMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired
    RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMq message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setCreated(new Date());
        try {
            template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTINGKEY, message);
            return "Message Published";
        } catch (Exception ex) {
            return "Exception occured while sending message";
        }
    }
}
