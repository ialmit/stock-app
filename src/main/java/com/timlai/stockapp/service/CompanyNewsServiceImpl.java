package com.timlai.stockapp.service;

import com.timlai.stockapp.DTO.CompanyNewsDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;
import com.timlai.stockapp.exceptions.CompanyNewsException;
import com.timlai.stockapp.exceptions.ErrorMessages;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Log4j2
@Service
public class CompanyNewsServiceImpl implements CompanyNewsService {
    private RestTemplate restTemplate;

    public CompanyNewsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${finnhub.token}")
    private String token;

    @Value("${finnhub.baseUrl_GetCompanyNews}")
    private String baseUrl_GetCompanyNews;

    private CompanyNewsDTO[] companyNewsDTOS;

    private String stockSymbol;

    private LocalDate today = LocalDate.now();
    private LocalDate todayMinusThreeDays = today.minusDays(3);

    //Company news will be displayed on the search results page
    @Override
    public CompanyNewsDTO[] getCompanyNews(StockSymbolDTO stockSymbolDTO) {
        //Symbol will come from the POST search request
        this.stockSymbol = stockSymbolDTO.getStockSymbolDTO().toUpperCase();

        String uri = baseUrl_GetCompanyNews + stockSymbol + "&from=" + todayMinusThreeDays + "&to=" + today + "&token=" + token;

        ResponseEntity<CompanyNewsDTO[]> response = restTemplate.getForEntity(uri, CompanyNewsDTO[].class);

        if (response.getBody().length > 1) {
            companyNewsDTOS = response.getBody();
        } else {
            log.error("CompanyNewsDTO is null for stockSymbol: " + stockSymbol + " and date range " + todayMinusThreeDays + " - " + today);
            throw new CompanyNewsException(ErrorMessages.COMPANY_NEWS_IS_NULL.getErrorMessage());
        }

        return companyNewsDTOS;
    }
}
