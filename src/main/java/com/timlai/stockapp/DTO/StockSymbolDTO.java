package com.timlai.stockapp.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StockSymbolDTO {

    @NotEmpty(message = "*This ticker cannot be empty")
    @Size(min = 1, max = 5, message = "*The ticker symbol can only be between 1 and 5 characters")
    @Pattern(regexp = "[a-zA-Z]*", message = "*Please enter only letters")
    private String stockSymbolDTO;
}
