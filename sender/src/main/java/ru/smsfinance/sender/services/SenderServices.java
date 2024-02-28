package ru.smsfinance.sender.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.smsfinance.library.model.RequestDto;
import ru.smsfinance.library.model.ResponseDto;
import ru.smsfinance.sender.configuration.AppConfiguration;

@Service
@Slf4j
public class SenderServices {

    @Autowired
    private AppConfiguration appConfiguration;

    @Autowired
    private RestTemplate restTemplate;


    public ResponseDto sendPing() {
        try {
            return restTemplate.getForObject(appConfiguration.getUrlPing(), ResponseDto.class);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Проблемы с конфигурацией. url.ping некорректный ", e);
            return null;
        }
    }

    public ResponseDto sendPong(RequestDto requestDto) {
        try {
            return restTemplate.postForObject(appConfiguration.getUrlPong(),
                    requestDto, ResponseDto.class);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Проблемы с конфигурацией. url.pong некорректный ", e);
            return null;
        }
    }
}