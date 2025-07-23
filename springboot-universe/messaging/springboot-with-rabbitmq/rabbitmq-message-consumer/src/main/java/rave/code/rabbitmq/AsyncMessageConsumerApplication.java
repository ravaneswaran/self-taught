package rave.code.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsyncMessageConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncMessageConsumerApplication.class, args);
    }

}
