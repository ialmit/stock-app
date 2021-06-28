package com.timlai.stockapp.exceptions;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ErrorMessage {
    private Date timeStamp;
    private String message;
}
