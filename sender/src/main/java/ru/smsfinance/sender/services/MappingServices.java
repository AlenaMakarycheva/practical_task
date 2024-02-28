package ru.smsfinance.sender.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smsfinance.sender.configuration.RequestDtoConfiguration;
import ru.smsfinance.library.model.*;


@Service
public class MappingServices {

    @Autowired
    private RequestDtoConfiguration requestDtoConfiguration;

    public RequestDto getDefaultRequestDto() {
        RequestDto requestDto = new RequestDto();
        requestDto.setName(requestDtoConfiguration.getName());
        requestDto.setDate(requestDtoConfiguration.getDate());
        requestDto.setRequest(requestDtoConfiguration.getRequest());
        return requestDto;
    }

}
