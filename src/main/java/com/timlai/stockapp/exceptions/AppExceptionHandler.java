package com.timlai.stockapp.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    public String handleStockSymbolException(StockSymbolException e) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), e.getMessage());



        return errorMessage.getMessage();
    }

    @ExceptionHandler
    public String handleCompanyNewsException(CompanyNewsException e, Model model) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), e.getMessage());

        model.addAttribute("errorMessage", errorMessage.getMessage());

        return "error";
    }
}
