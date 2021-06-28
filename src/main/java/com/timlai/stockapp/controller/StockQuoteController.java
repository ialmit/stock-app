package com.timlai.stockapp.controller;

import com.timlai.stockapp.DTO.CompanyProfileDTO;
import com.timlai.stockapp.DTO.StockQuoteDTO;
import com.timlai.stockapp.DTO.StockSymbolDTO;
import com.timlai.stockapp.exceptions.ErrorMessages;
import com.timlai.stockapp.exceptions.StockSymbolException;
import com.timlai.stockapp.service.StockQuoteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Log4j2
@Controller
public class StockQuoteController {

    private StockQuoteService stockQuoteService;
    private StockQuoteDTO stockQuoteDTO;
    private CompanyProfileDTO companyProfileDTO;
    private CompanyNewsController companyNewsController;

    public StockQuoteController(StockQuoteService stockQuoteService, CompanyNewsController companyNewsController) {
        this.stockQuoteService = stockQuoteService;
        this.companyNewsController = companyNewsController;
    }

    //The User hits this endpoint and it makes a GET request to the finnhub stock quote api.
    //The User passes in a stock symbol to search for.
    //The data retrieved from the GET request will be displayed on the GUI
//    https://stackoverflow.com/a/40899905/3791405

    @PostMapping(value = "/search")
    public String getStockQuoteForASingleCompany(@ModelAttribute(name = "stockSymbolDTO") @Valid StockSymbolDTO stockSymbolDTO,
                                                 BindingResult bindingResult, Model model) {
        if (stockSymbolDTO == null) {
            throw new StockSymbolException(ErrorMessages.STOCK_SYMBOL_IS_NULL.getErrorMessage());
        }

        this.stockQuoteDTO = stockQuoteService.searchBySymbol(stockSymbolDTO);
        this.companyProfileDTO = stockQuoteService.getCompanyInfoBySymbol(stockSymbolDTO.getStockSymbolDTO());

        model.addAttribute("stockPrices", stockQuoteDTO);
        model.addAttribute("companyProfile", companyProfileDTO);
        model.addAttribute("companyNews", companyNewsController.displayCompanyNews(stockSymbolDTO));

        return "home/results";

    }
}
