package ru.smsfinance.receiver.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smsfinance.receiver.configuration.ResponseDtoConfiguration;
import ru.smsfinance.library.model.*;


@Service
public class ResponseDtoServices {

    @Autowired
    private ResponseDtoConfiguration responseDtoConfiguration;

    public ResponseDtoServices(){

        responseDtoConfiguration = new ResponseDtoConfiguration();
    }

    public ResponseDto getDefaultResponseDto(){
        ResponseDto responseDto= new ResponseDto();
        responseDto.setName(responseDtoConfiguration.getName());
        responseDto.setDate(responseDtoConfiguration.getDate());
        responseDto.setResponse(responseDtoConfiguration.getResponse());
        return responseDto;
    }
}
