package ru.smsfinance.sender.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.smsfinance.library.model.RequestDto;
import ru.smsfinance.sender.configuration.RequestDtoConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class MappingServicesTest {

    @InjectMocks
    MappingServices mappingServices;

    @Mock
    RequestDtoConfiguration requestDtoConfiguration;

    @Test
    void nullPointerDefaultRequestTest() {
        Mockito.when(requestDtoConfiguration.getName()).thenReturn(null);
        Mockito.when(requestDtoConfiguration.getDate()).thenReturn(null);
        Mockito.when(requestDtoConfiguration.getRequest()).thenReturn(null);
        RequestDto requestDto = mappingServices.getDefaultRequestDto();
        assertNull(requestDto.getName());
        assertNull(requestDto.getDate());
        assertNull(requestDto.getRequest());
    }
}