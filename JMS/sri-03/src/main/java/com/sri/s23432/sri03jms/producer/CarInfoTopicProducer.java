package com.sri.s23432.sri03jms.producer;

import com.sri.s23432.sri03jms.config.JmsConfig;
import com.sri.s23432.sri03jms.model.CarMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;
@Component
@RequiredArgsConstructor
public class CarInfoTopicProducer {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 15000)
    public void sendCarInfo(){
        CarMessage message = CarMessage.builder()
                .id(CarMessage.nextId())
                .createdAt(LocalDateTime.now())
                .message("Car Info:")
                .engineTemp(Math.random()*(2700-2000+1)+2000)
                .frontTyrePressure(Math.random()*(26-21+1)+21)
                .rearTyrePressure(Math.random()*(22-17+1)+17)
                .oilPressure(Math.random()*(25-13+1)+13)
                .build();
        jmsTemplate.convertAndSend(JmsConfig.TOPIC_CAR_INFO,message);
        System.out.println("Car info - sent message: " + message);
    }
}
