package ru.smsfinance.receiver.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ResponseDtoConfiguration {

    @Value("${responseDtoDef.name}")
    private String name;

    @Value("${responseDtoDef.date}")
    private String date;

    @Value("${responseDtoDef.response}")
    private String response;

    public String getName() {
        return name;
    }

    public Date getDate() {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException | NullPointerException e) {
            return null;
        }
    }

    public String getResponse() {
        return response;
    }
}
