package com.sri.s23432.sri03jms.receiver;

import com.sri.s23432.sri03jms.config.JmsConfig;
import com.sri.s23432.sri03jms.model.CarMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class CarInfoTopicLogReceiver {

    File file = new File("Logs.txt");;

    @JmsListener(destination = JmsConfig.TOPIC_CAR_INFO, containerFactory = "topicConnectionFactory")
    public void receiveCarMessage(@Payload CarMessage convertedMessage,
                                    @Headers MessageHeaders messageHeaders,
                                    Message message){
        try{
            if(!file.exists()){
                File file = new File("Logs.txt");
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(convertedMessage.toString());
                fileWriter.close();
            } else {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write("\n" + convertedMessage.toString());
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("CarInfoTopicLogReceiver.receiveCarMessage, message: " + convertedMessage);
    }
}
