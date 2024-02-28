package ru.smsfinance.sender.configuration;

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
class RequestDtoConfigurationTest {

    @InjectMocks
    RequestDtoConfiguration requestDtoConfiguration;

    @Test
    void nullPointerDateTest() {
        assertEquals(requestDtoConfiguration.getDate(), null);
    }

    @SneakyThrows
    @Test
    void invalidDateTest() {
        Field field = requestDtoConfiguration.getClass().getDeclaredField("date");
        field.setAccessible(true);
        field.set(requestDtoConfiguration, "qwerty");
        assertEquals(requestDtoConfiguration.getDate(), null);
    }
}