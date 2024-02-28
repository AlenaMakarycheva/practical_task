package ru.smsfinance.sender;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.smsfinance.sender.services.MappingServices;
import ru.smsfinance.sender.services.SenderServices;


/**
 * - отправка GET/POST запросов в первый сервис по расписанию
 * get/post запросы  реализовать с использованием RestTemplate
 * -- передача и получение dto в формате json с записью результата в лог
 */
@Service
@AllArgsConstructor
@Slf4j
public class PingPongJob {

    private final MappingServices mappingServices;
    private final SenderServices senderServices;

    @Scheduled(fixedDelayString = "${delayPing}")
    public void getPing() {
        log.info("ping-{}", senderServices.sendPing());
    }

    @Scheduled(cron = "${cronPong}")
    public void getPong() {
        log.info("pong-{}", senderServices.sendPong(mappingServices.getDefaultRequestDto()));
    }
}
