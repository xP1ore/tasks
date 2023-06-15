package DigDesSchool.amqp.config;

import DigDesSchool.email.Sender;
import jakarta.mail.MessagingException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConsumer {
    private final RabbitTemplate rabbitTemplate;

    private final Sender sender;

    public MessageConsumer(RabbitTemplate rabbitTemplate, Sender sender) {
        this.rabbitTemplate = rabbitTemplate;
        this.sender = sender;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recieve(Message message) throws MessagingException {
        String text = "some text";
        sender.send(text);
    }
}
