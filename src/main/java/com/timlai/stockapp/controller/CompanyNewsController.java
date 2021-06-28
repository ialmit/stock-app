package com.timlai.stockapp.controller;

import com.timlai.stockapp.DTO.CompanyNewsDTO;
import com.timlai.stockapp.DTO.MarketNewsDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;
import com.timlai.stockapp.service.CompanyNewsService;
import com.timlai.stockapp.utils.CompanyNewsUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class CompanyNewsController {

    private CompanyNewsDTO[] companyNewsDTO;

    private CompanyNewsService companyNewsService;

    private CompanyNewsUtils companyNewsUtils;

    private List<CompanyNewsDTO> companyNewsDTOList;

    public CompanyNewsController(CompanyNewsService companyNewsService, CompanyNewsUtils companyNewsUtils) {
        this.companyNewsService = companyNewsService;
        this.companyNewsUtils = companyNewsUtils;
    }

    public List<CompanyNewsDTO> displayCompanyNews(StockSymbolDTO stockSymbol) {

        companyNewsDTO = companyNewsService.getCompanyNews(stockSymbol);

        companyNewsDTOList = companyNewsUtils.getRandomNewsStoriesToDisplay(companyNewsDTO, 5);

        return companyNewsDTOList;

    }
}
