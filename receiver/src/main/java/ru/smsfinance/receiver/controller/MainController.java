package ru.smsfinance.receiver.controller;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.smsfinance.library.model.*;
import ru.smsfinance.receiver.services.PingPongProcessingServices;



/**
 * - прием GET запроса по адресу:   {base_url}/ping
 * - прием POST запроса по адресу: {base_url}/pong с получением и отправкой ответа
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class MainController {

   private final PingPongProcessingServices pingPongProcessingServices;

   @Timed("pingMetric")
    @GetMapping(path = "/ping", produces = "application/json")
    public ResponseDto ping(){
        log.info("ping получен");
        return pingPongProcessingServices.responseToPing();
    }

    @Timed("pongMetric")
    @PostMapping("/pong")
    public ResponseDto pong(@RequestBody RequestDto requestDto){
        log.info("pong-{}",requestDto);
        return pingPongProcessingServices.responseToPong(requestDto);
    }
}
