package com.timlai.stockapp.controller;

import com.timlai.stockapp.DTO.MarketNewsDTO;
import com.timlai.stockapp.service.MarketNewsService;
import com.timlai.stockapp.utils.MarketNewsUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class MarketNewsController {

    private MarketNewsDTO[] marketNewsDTO;

    private MarketNewsService marketNewsService;

    private MarketNewsUtils marketNewsUtils;

    private List<MarketNewsDTO> marketNewsDTOList;

    public MarketNewsController(MarketNewsService marketNewsService, MarketNewsUtils marketNewsUtils) {
        this.marketNewsService = marketNewsService;
        this.marketNewsUtils = marketNewsUtils;
    }

    public List<MarketNewsDTO> displayMarketNews() {

        marketNewsDTO = marketNewsService.getMarketNews();

        marketNewsDTOList = marketNewsUtils.getRandomNewsStoriesToDisplay(marketNewsDTO, 5);

        return marketNewsDTOList;

    }
}
