package rave.code.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "exampleQueue";

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}
