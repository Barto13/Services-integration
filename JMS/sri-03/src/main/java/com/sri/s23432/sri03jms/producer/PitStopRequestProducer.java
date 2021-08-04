package com.sri.s23432.sri03jms.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sri.s23432.sri03jms.config.JmsConfig;
import com.sri.s23432.sri03jms.model.PitStopRequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.time.LocalDateTime;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class PitStopRequestProducer {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;
    Random random = new Random();
    Boolean decision;

    @Scheduled(fixedRate = 15000)
    public void sendAndReceive() throws JMSException, JsonProcessingException {
        decision = random.nextBoolean();

        if(decision == true){
            PitStopRequestMessage message = PitStopRequestMessage.builder()
                    .id(PitStopRequestMessage.nextId())
                    .createdAt(LocalDateTime.now())
                    .message("Driver: Required permission to enter the pitstop")
                    .build();
            TextMessage responseMessage = (TextMessage) jmsTemplate.sendAndReceive(
                    JmsConfig.QUEUE_PITSTOP_SEND_AND_RECEIVE, new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            TextMessage plainMessage = session.createTextMessage();
                            try{
                                plainMessage.setText(objectMapper.writeValueAsString(message));
                                plainMessage.setStringProperty("_type", PitStopRequestMessage.class.getName());
                                return plainMessage;
                            }catch (JsonProcessingException e){
                                throw new JMSException("conversion to json failed: "  + e.getMessage());
                            }
                        }
                    }
            );
            String responseText = responseMessage.getText();

            PitStopRequestMessage responseConverted = objectMapper.readValue(responseText, PitStopRequestMessage.class);
            System.out.println("Driver got response: "
                    + responseText + "\n\tconvertedMessage: " + responseConverted);
        } else {
            System.out.println("PitStop request not sent");
        }
    }
}
