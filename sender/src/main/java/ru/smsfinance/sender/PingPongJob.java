package ru.smsfinance.sender;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.smsfinance.library.model.ResponseDto;
import ru.smsfinance.sender.configuration.AppConfiguration;
import ru.smsfinance.sender.services.RequestDtoServices;


/**
 * - отправка GET/POST запросов в первый сервис по расписанию
 * get/post запросы  реализовать с использованием RestTemplate
 * -- передача и получение dto в формате json с записью результата в лог
 */
@Service
@AllArgsConstructor
@Slf4j
public class PingPongJob {

    private final AppConfiguration appConfiguration;
    private final RequestDtoServices requestDtoServices;

    @Scheduled(cron = "${crontab.cronPing}")
    public void getResponseDto()//ping
    {
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.getForObject(appConfiguration.getUrlPing(), ResponseDto.class);
        log.info("getResponseDto-{}",restTemplate.getForObject(appConfiguration.getUrlPing(), ResponseDto.class));
    }

    @Scheduled(cron = "${crontab.cronPong}")
    public void postResponseDto()//pong
    {
        RestTemplate restTemplate = new RestTemplate();
        /*restTemplate.postForObject(appConfiguration.getUrlPong(),
                requestDtoServices.getDefaultRequestDto(), ResponseDto.class);*/
        log.info("postResponseDto-{}",restTemplate.postForObject(appConfiguration.getUrlPong(),
                requestDtoServices.getDefaultRequestDto(), ResponseDto.class));
    }
}
