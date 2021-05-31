package com.timlai.stockapp.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StockSymbolDTO {

    @NotEmpty
    @Size(min = 1, max = 5)
    @Pattern(regexp = "[a-zA-Z]*")
    private String stockSymbolDTO;
}
