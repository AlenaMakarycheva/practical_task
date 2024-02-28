package ru.smsfinance.receiver.utils;

import java.util.Optional;

public class FormattingUtil {
    private static final String DEFAULT_RESPONSE_TEMPLATE = "Нет ответа на %s";

    public static String formattingResponse(String responseString,Object obj){
        return String.format(Optional.ofNullable(responseString)
                .orElse(DEFAULT_RESPONSE_TEMPLATE), obj);
    }
}
