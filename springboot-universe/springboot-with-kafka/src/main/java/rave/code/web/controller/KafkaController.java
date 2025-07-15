package rave.code.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rave.code.kafka.producers.MessageProducer;

@RestController
public class KafkaController {

    //http://localhost:8080/send?message=Hello_Kafka

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        this.messageProducer.sendMessage("quickstart-events", message);
        return "Message sent: " + message;
    }
}
