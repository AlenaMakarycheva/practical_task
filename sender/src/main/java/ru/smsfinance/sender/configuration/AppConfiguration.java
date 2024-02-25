package ru.smsfinance.sender.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class AppConfiguration {

    @Value("${url.ping}")
    private String urlPing;

    @Value("${url.pong}")
    private String urlPong;

}
