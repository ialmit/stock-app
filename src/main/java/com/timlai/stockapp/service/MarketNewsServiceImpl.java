package com.timlai.stockapp.service;

import com.timlai.stockapp.DTO.MarketNewsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarketNewsServiceImpl implements MarketNewsService {
    private RestTemplate restTemplate;

    public MarketNewsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${finnhub.token}")
    private String token;

    @Value("${finnhub.baseUrl_GetMarketNews}")
    private String baseUrl_GetMarketNews;

    private MarketNewsDTO[] marketNewsDTOS;

    //Return the 5 random news stories from the getMarketNews() method

    @Override
    public MarketNewsDTO[] getMarketNews() {
        String uri = baseUrl_GetMarketNews + token;

        ResponseEntity<MarketNewsDTO[]> response = restTemplate.getForEntity(uri, MarketNewsDTO[].class);

        if (response != null) {
            marketNewsDTOS = response.getBody();
        } else {
            throw new RuntimeException("MarketNewsDTO response is null");
        }

        return marketNewsDTOS;
    }
}
