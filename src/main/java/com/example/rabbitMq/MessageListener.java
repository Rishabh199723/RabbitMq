package com.example.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MessageConfig.MESSAGE_QUEUE)
    public void listen(CustomMq message) {
        System.out.println(message);
    }
}
