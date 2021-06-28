package com.timlai.stockapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorMessages {

    STOCK_SYMBOL_IS_NULL("The stock symbol is null"),
    COMPANY_NEWS_IS_NULL("The company news is null");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
