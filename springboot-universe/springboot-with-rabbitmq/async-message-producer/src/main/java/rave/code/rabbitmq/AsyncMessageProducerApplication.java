package rave.code.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsyncMessageProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncMessageProducerApplication.class, args);
    }

}
