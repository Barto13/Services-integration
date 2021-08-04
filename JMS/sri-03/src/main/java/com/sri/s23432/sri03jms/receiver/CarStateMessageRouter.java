package com.sri.s23432.sri03jms.receiver;

import com.sri.s23432.sri03jms.config.JmsConfig;
import com.sri.s23432.sri03jms.model.CarMessage;
import com.sri.s23432.sri03jms.model.WarningMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CarStateMessageRouter {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.TOPIC_CAR_INFO, containerFactory = "topicConnectionFactory")
    public void receiveCarMessage(@Payload CarMessage convertedMessage,
                                  @Headers MessageHeaders messageHeaders,
                                  Message message){
        if(convertedMessage.getEngineTemp() > 2675 || convertedMessage.getEngineTemp() < 2025 ||
                convertedMessage.getFrontTyrePressure() > 25.7 || convertedMessage.getFrontTyrePressure() < 21.3 ||
                convertedMessage.getRearTyrePressure() > 21.7 || convertedMessage.getRearTyrePressure() < 17.3 ||
                convertedMessage.getOilPressure() > 24.7 || convertedMessage.getOilPressure() < 13.3) {
            //send to driver & mechanic
            sendWarning();
            sendWarningToMechanic();

        } else if(convertedMessage.getEngineTemp() > 2650 || convertedMessage.getEngineTemp() < 2050 ||
                convertedMessage.getFrontTyrePressure() > 25.5 || convertedMessage.getFrontTyrePressure() < 21.5 ||
                convertedMessage.getRearTyrePressure() > 21.5 || convertedMessage.getRearTyrePressure() < 17.5 ||
                convertedMessage.getOilPressure() > 24.5 || convertedMessage.getOilPressure() < 13.5){
            //send to driver
            sendWarning();

        }else{
            System.out.println("ALL PARAMETERS OK!, CarStateMessageRouter.receiveCarMessage, message: " + convertedMessage);
        }
//        System.out.println("CarStateMessageRouter.receiveCarMessage, message: " + convertedMessage);
    }

    public void sendWarning(){
        WarningMessage message = WarningMessage.builder()
                .id(WarningMessage.nextId())
                .createdAt(LocalDateTime.now())
                .message("Some car parameters are not ok!")
                .build();
        jmsTemplate.convertAndSend(JmsConfig.QUEUE_CAR_INFO_DRIVER,message);
        System.out.println("Warning sent to driver: " + message);
    }
    public void sendWarningToMechanic(){
        WarningMessage message = WarningMessage.builder()
                .id(WarningMessage.nextId())
                .createdAt(LocalDateTime.now())
                .message("Some car parameters are not ok! Car needs repairs!")
                .build();
        jmsTemplate.convertAndSend(JmsConfig.QUEUE_CAR_INFO_MECHANIC,message);
        System.out.println("Warning sent to Mechanic: " + message);
    }

}
