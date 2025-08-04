package rave.code.activemq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @Value("${spring.activemq.queue}")
    String queue;

    @JmsListener(destination = "activemq-queue")
    @SendTo("myQueue2")
    public String receiveAndForwardMessageFromQueue(final Message jsonMessage) throws JMSException {
        String messageData = null;
        System.out.println("Received message " + jsonMessage);
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            System.out.println("messageData:" + messageData);
        }
        return messageData;
    }

    @JmsListener(destination = "activemq-topic")
    @SendTo("activemq-topic-1")
    public String receiveAndForwardMessageFromTopic(final Message jsonMessage) throws JMSException, JsonProcessingException {
        String messageData = null;
        System.out.println("Received message " + jsonMessage);
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            System.out.println("messageData:" + messageData);
        }
        return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(messageData);
    }

    @JmsListener(destination = "activemq-topic")
    public void receiveMessageFromTopic(final Message jsonMessage) throws JMSException {
        String messageData = null;
        System.out.println("Received message in 2nd topic " + jsonMessage);
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            System.out.println("messageData in 2nd listener:" + messageData);
        }
    }
}
