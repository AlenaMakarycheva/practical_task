package ru.smsfinance.sender.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Data
public class AppConfiguration {

    @Value("${url.ping}")
    private String urlPing;

    @Value("${url.pong}")
    private String urlPong;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
