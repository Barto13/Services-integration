package com.sri.s23432.sri03jms.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarMessage {
    private static long idIndex = 0;
    public static long nextId(){
        return idIndex++;
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    private long id;
    private String message;
    private Double engineTemp;
    private Double frontTyrePressure;
    private Double rearTyrePressure;
    private Double oilPressure;

//    private Double engineTemp = Math.random()*(2700-2000+1)+2000;
//    private Double frontTyrePressure = Math.random()*(26-21+1)+21;
//    private Double rearTyrePressure = Math.random()*(22-17+1)+17;
//    private Double oilPressure = Math.random()*(25-13+1)+13;
}
