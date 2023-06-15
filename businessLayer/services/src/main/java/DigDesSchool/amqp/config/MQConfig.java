package DigDesSchool.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    private String queue;
    private String key;
    private String exchange;

    public Queue queue() {
        return new Queue(queue, false);
    }

    public DirectExchange exchange(){
        return new DirectExchange(exchange);
    }

    public Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(key);
    }

}
