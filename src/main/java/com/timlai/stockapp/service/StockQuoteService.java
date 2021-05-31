package com.timlai.stockapp.service;

import com.timlai.stockapp.DTO.CompanyProfileDTO;
import com.timlai.stockapp.DTO.StockQuoteDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;

public interface StockQuoteService {
    StockQuoteDTO searchBySymbol(StockSymbolDTO stockSymbolDTO);

    CompanyProfileDTO getCompanyInfoBySymbol(String symbol);
}
