package ru.smsfinance.library.model;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseDto {
    private String name;
    private Date date;
    private String response;
}
