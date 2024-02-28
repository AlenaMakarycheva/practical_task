package ru.smsfinance.receiver.utils;

import java.util.Optional;

public class FormattingUtil {

    public static String formattingResponse(String responseString,Object obj){
        return String.format(Optional.ofNullable(responseString)
                .orElse("Нет ответа на %s"), obj);
    }
}
