package ru.smsfinance.receiver.configuration;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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

    @SneakyThrows
    public Date getDate() {
        return new SimpleDateFormat("dd.MM.yyyy").parse(date);
    }

    public String getResponse() {
        return response;
    }
}
