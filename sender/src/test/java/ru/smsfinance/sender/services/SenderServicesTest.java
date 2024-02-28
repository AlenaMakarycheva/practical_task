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
import ru.smsfinance.sender.configuration.AppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class SenderServicesTest {

    @InjectMocks
    SenderServices senderServices;

    @Mock
    AppConfiguration appConfiguration;

    @Test
    void nullPointerUrlTest() {
        Mockito.when(appConfiguration.getUrlPing()).thenReturn(null);
        Mockito.when(appConfiguration.getUrlPong()).thenReturn(null);
        assertEquals(senderServices.sendPing(), null);
        assertEquals(senderServices.sendPong(new RequestDto()), null);
    }

    @Test
    void invalidUrlTest() {
        Mockito.when(appConfiguration.getUrlPing()).thenReturn("qwerty");
        Mockito.when(appConfiguration.getUrlPong()).thenReturn("qwerty");
        assertEquals(senderServices.sendPing(), null);
        assertEquals(senderServices.sendPong(new RequestDto()), null);
    }
}