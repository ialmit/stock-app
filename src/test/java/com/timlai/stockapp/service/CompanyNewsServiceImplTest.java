package com.timlai.stockapp.service;

import com.timlai.stockapp.DTO.CompanyNewsDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class CompanyNewsServiceImplTest {

    @Autowired
    private CompanyNewsService companyNewsService;

    private StockSymbolDTO stockSymbolDTO;

    CompanyNewsDTO[] news;

    @BeforeEach
    void setUp() {
        stockSymbolDTO = new StockSymbolDTO();
        stockSymbolDTO.setStockSymbolDTO("AAPL");
    }

    @Test
    void getCompanyNewsTest() {

        news = companyNewsService.getCompanyNews(stockSymbolDTO);
        Assertions.assertNotNull(news);

        System.out.println(Arrays.toString(news));
    }
}