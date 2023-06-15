package DigDesSchool.amqp.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Value("${rabbitmq.routingKey}")
    private String key;

    @Value("${rabbitmq.exchange}")
    private String exchange;
    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send() {
        rabbitTemplate.convertAndSend(exchange, key, "message");
    }

}
