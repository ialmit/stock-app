package com.timlai.stockapp.controller;

import com.timlai.stockapp.DTO.MarketNewsDTO;
import com.timlai.stockapp.service.MarketNewsService;
import com.timlai.stockapp.utils.MarketNewsUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Log4j2
@Controller
public class MarketNewsController {

    private MarketNewsDTO[] marketNewsDTO;

    private MarketNewsService marketNewsService;

    private MarketNewsUtils marketNewsUtils;

    private List<MarketNewsDTO> marketNewsDTOList;

    public MarketNewsController(MarketNewsService marketNewsService, MarketNewsUtils marketNewsUtils) {
        this.marketNewsService = marketNewsService;
        this.marketNewsUtils = marketNewsUtils;
    }

    //This actually should not be a controller.......................
    // I should actually just take this displayMarketNews() method and use it in the HomeController
//    @GetMapping("/market-news")
    public List<MarketNewsDTO> displayMarketNews() {

        marketNewsDTO = marketNewsService.getMarketNews();

        marketNewsDTOList = marketNewsUtils.getRandomNewsStoriesToDisplay(marketNewsDTO, 5);

        return marketNewsDTOList;
//        model.addAttribute("marketNewsList", marketNewsDTOList);


//        return "home/test";
    }


    //im confused...
    //I want to add this news to the MarketNews fragment.
    // The MarketNews fragment will be displayed on the home page (index.html)
}
