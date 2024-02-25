package ru.smsfinance.sender.configuration;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
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

    @SneakyThrows
    public Date getDate() {
        return new SimpleDateFormat("dd.MM.yyyy").parse(date);
    }

    public String getRequest() {
        return request;
    }
}
