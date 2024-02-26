package ru.smsfinance.sender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.smsfinance.library.model.RequestDto;
import ru.smsfinance.library.model.ResponseDto;
import ru.smsfinance.sender.configuration.AppConfiguration;

@Service
public class SenderServices {

    @Autowired
    private AppConfiguration appConfiguration;

    @Autowired
    private RestTemplate restTemplate;


    public ResponseDto sendPing() {
        return restTemplate.getForObject(appConfiguration.getUrlPing(), ResponseDto.class);
    }

    public ResponseDto sendPong(RequestDto requestDto) {
        return restTemplate.postForObject(appConfiguration.getUrlPong(),
                requestDto, ResponseDto.class);
    }
}
