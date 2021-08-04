package com.sri.s23432.sri03jms.receiver;

import com.sri.s23432.sri03jms.config.JmsConfig;
import com.sri.s23432.sri03jms.model.PitStopRequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.time.LocalDateTime;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class PitStopRequestReceiver {

    private final JmsTemplate jmsTemplate;
    Random random = new Random();
    Boolean decision;

    @JmsListener(destination = JmsConfig.QUEUE_PITSTOP_SEND_AND_RECEIVE)
    public void receiveAndRespond(@Payload PitStopRequestMessage convertedMessage,
                                  @Headers MessageHeaders headers,
                                  Message message) throws JMSException {
        decision = random.nextBoolean();
        if(decision == true){
            System.out.println("Team Leader received message: " + convertedMessage);
            Destination replyTo = message.getJMSReplyTo();
            PitStopRequestMessage msg = PitStopRequestMessage.builder()
                    .id(PitStopRequestMessage.nextId())
                    .createdAt(LocalDateTime.now())
                    .message("Permission granted, you can go")
                    .build();
            jmsTemplate.convertAndSend(replyTo, msg);
        } else if(decision == false){
            System.out.println("Team Leader received request message: " + convertedMessage);
            Destination replyTo = message.getJMSReplyTo();
            PitStopRequestMessage msg = PitStopRequestMessage.builder()
                    .id(PitStopRequestMessage.nextId())
                    .createdAt(LocalDateTime.now())
                    .message("Request denied, you can't go")
                    .build();
            jmsTemplate.convertAndSend(replyTo, msg);
        }
    }
}
