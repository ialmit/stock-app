package com.timlai.stockapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

//This represents the stock quote that is returned from finnhub. This object will not be stored in the DB.

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Component
public class StockQuoteDTO {
    @JsonProperty("o")
    private double openPrice;

    @JsonProperty("h")
    private double highPrice;

    @JsonProperty("l")
    private double lowPrice;

    @JsonProperty("c")
    private double currentPrice;

    @JsonProperty("pc")
    private double previousClosePrice;

    @JsonProperty("t")
    private long timestamp;
}
