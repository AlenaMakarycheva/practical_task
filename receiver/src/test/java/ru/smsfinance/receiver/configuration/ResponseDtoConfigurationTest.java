package ru.smsfinance.receiver.configuration;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ResponseDtoConfigurationTest {

    @InjectMocks
    ResponseDtoConfiguration responseDtoConfiguration;

    @Test
    void nullPointerDateTest() {
        assertNull(responseDtoConfiguration.getDate());
    }

    @SneakyThrows
    @Test
    void invalidDateTest() {
        Field field = responseDtoConfiguration.getClass().getDeclaredField("date");
        field.setAccessible(true);
        field.set(responseDtoConfiguration, "qwerty");
        assertNull(responseDtoConfiguration.getDate());
    }

}