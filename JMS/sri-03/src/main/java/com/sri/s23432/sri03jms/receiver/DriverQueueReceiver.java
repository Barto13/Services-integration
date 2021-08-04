package com.sri.s23432.sri03jms.receiver;

import com.sri.s23432.sri03jms.config.JmsConfig;
import com.sri.s23432.sri03jms.model.WarningMessage;
import org.springframework.jms.annotation.JmsListener;

import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class DriverQueueReceiver {

    @JmsListener(destination = JmsConfig.QUEUE_CAR_INFO_DRIVER, containerFactory = "queueConnectionFactory")
    public void receiveCarInfoMessage(@Payload WarningMessage convertedMessage,
                                    @Headers MessageHeaders messageHeaders,
                                    Message message){
        System.out.println("Driver received message - :" + convertedMessage);

    }
}
