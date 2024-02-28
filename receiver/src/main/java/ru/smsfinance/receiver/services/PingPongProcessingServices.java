package ru.smsfinance.receiver.services;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smsfinance.library.model.RequestDto;
import ru.smsfinance.library.model.ResponseDto;
import ru.smsfinance.receiver.configuration.ResponseDtoConfiguration;
import ru.smsfinance.receiver.utils.FormattingUtil;

@Service
public class PingPongProcessingServices {
    @Autowired
    private ResponseDtoConfiguration responseDtoConfiguration;

    private final String PING = "ping";

    public PingPongProcessingServices() {
        responseDtoConfiguration = new ResponseDtoConfiguration();
    }

    protected ResponseDto getDefaultResponseDto() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setName(responseDtoConfiguration.getName());
        responseDto.setDate(responseDtoConfiguration.getDate());
        responseDto.setResponse(responseDtoConfiguration.getResponse());
        return responseDto;
    }


    public ResponseDto responseToPong(RequestDto requestDto) {
        ResponseDto responseDto = getDefaultResponseDto();
        responseDto.setResponse(FormattingUtil.formattingResponse(responseDto.getResponse(),requestDto));
        return responseDto;
    }

    public ResponseDto responseToPing() {
        ResponseDto responseDto = getDefaultResponseDto();
        responseDto.setResponse(FormattingUtil.formattingResponse(responseDto.getResponse(),PING));
        return responseDto;
    }
}
