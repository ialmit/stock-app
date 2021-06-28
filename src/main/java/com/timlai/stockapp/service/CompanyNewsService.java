package com.timlai.stockapp.service;

import com.timlai.stockapp.DTO.CompanyNewsDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;

public interface CompanyNewsService {

    CompanyNewsDTO[] getCompanyNews(StockSymbolDTO stockSymbolDTO);
}
