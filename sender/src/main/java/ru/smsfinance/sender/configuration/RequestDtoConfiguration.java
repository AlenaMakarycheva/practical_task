package ru.smsfinance.sender.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class RequestDtoConfiguration {

    @Value("${requestDtoDef.name}")
    private String name;

    @Value("${requestDtoDef.date}")
    private String date;

    @Value("${requestDtoDef.request}")
    private String request;

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

    public String getRequest() {
        return request;
    }
}
