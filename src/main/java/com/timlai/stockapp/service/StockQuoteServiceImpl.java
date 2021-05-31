package com.timlai.stockapp.service;

import com.timlai.stockapp.DTO.CompanyProfileDTO;
import com.timlai.stockapp.DTO.StockQuoteDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Log4j2
@Service
public class StockQuoteServiceImpl implements StockQuoteService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Value("${finnhub.token}")
    private String token;

    @Value("${finnhub.baseUrl_SearchBySymbol}")
    private String baseUrl_SearchBySymbol;

    @Value("${finnhub.baseUrl_CompanyInfo}")
    private String baseUrl_CompanyInfo;

    private static String formattedStockSymbol;

    @Override
    public StockQuoteDTO searchBySymbol(StockSymbolDTO stockSymbolDTO) {

        this.formattedStockSymbol = stockSymbolDTO.getStockSymbolDTO().toUpperCase();

        String uri = baseUrl_SearchBySymbol + formattedStockSymbol + "&token=" + token;

        StockQuoteDTO stockQuoteDTO = restTemplate.getForObject(uri, StockQuoteDTO.class);
        log.info("The value of getStockSymbol() is: " + formattedStockSymbol);

        return stockQuoteDTO;
    }

    @Override
    public CompanyProfileDTO getCompanyInfoBySymbol(String symbol) {

        String uri = baseUrl_CompanyInfo + formattedStockSymbol + "&token=" + token;

        CompanyProfileDTO companyProfileDTO = restTemplate.getForObject(uri, CompanyProfileDTO.class);

        return companyProfileDTO;
    }
}
