package com.timlai.stockapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//This represents the stock quote that is returned from finnhub. This object will not be stored in the DB.

@Getter
@Setter
@AllArgsConstructor
public class StockQuote {

    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double currentPrice;
    private double previousClosePrice;
    private long timestamp;
}
