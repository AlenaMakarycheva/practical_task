package ru.smsfinance.receiver.services;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.smsfinance.library.model.RequestDto;
import ru.smsfinance.library.model.ResponseDto;
import ru.smsfinance.receiver.configuration.ResponseDtoConfiguration;
import ru.smsfinance.receiver.utils.FormattingUtil;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class PingPongProcessingServicesTest {

    @InjectMocks
    PingPongProcessingServices pingPongProcessingServices;

    @Mock
    ResponseDtoConfiguration responseDtoConfiguration;

    @Test
    void nullPointerDefaultResponseTest() {
        Mockito.when(responseDtoConfiguration.getName()).thenReturn(null);
        Mockito.when(responseDtoConfiguration.getDate()).thenReturn(null);
        Mockito.when(responseDtoConfiguration.getResponse()).thenReturn(null);
        ResponseDto responseDto = pingPongProcessingServices.getDefaultResponseDto();
        assertEquals(responseDto.getName(), null);
        assertEquals(responseDto.getDate(), null);
        assertEquals(responseDto.getResponse(), null);
    }

    @SneakyThrows
    @Test
    void nullPointerPingTest() {
        Field field = pingPongProcessingServices.getClass().getDeclaredField("PING");
        field.setAccessible(true);
        Mockito.when(responseDtoConfiguration.getName()).thenReturn(null);
        Mockito.when(responseDtoConfiguration.getDate()).thenReturn(null);
        Mockito.when(responseDtoConfiguration.getResponse()).thenReturn(null);
        ResponseDto responseDto = pingPongProcessingServices.responseToPing();
        assertEquals(responseDto.getName(), null);
        assertEquals(responseDto.getDate(), null);
        assertEquals(responseDto.getResponse(), FormattingUtil.formattingResponse(responseDto.getResponse(),field.get(pingPongProcessingServices)));
    }

    @Test
    void nullPointerPongTest() {
        Mockito.when(responseDtoConfiguration.getName()).thenReturn(null);
        Mockito.when(responseDtoConfiguration.getDate()).thenReturn(null);
        Mockito.when(responseDtoConfiguration.getResponse()).thenReturn(null);
        ResponseDto responseDto = pingPongProcessingServices.responseToPong(new RequestDto());
        assertEquals(responseDto.getName(), null);
        assertEquals(responseDto.getDate(), null);
        assertEquals(responseDto.getResponse(), FormattingUtil.formattingResponse(responseDto.getResponse(),new RequestDto()));
    }
}