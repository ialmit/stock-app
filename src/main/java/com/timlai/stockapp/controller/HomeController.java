package com.timlai.stockapp.controller;

import com.timlai.stockapp.DTO.StockSymbolDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    MarketNewsController marketNewsController;

    public HomeController(MarketNewsController marketNewsController) {
        this.marketNewsController = marketNewsController;
    }

    StockSymbolDTO stockSymbolDTOObject = new StockSymbolDTO();

    @GetMapping({"", "/", "/home"})
    public String getHomePage(Model model) {
        model.addAttribute("stockSymbolDTO", stockSymbolDTOObject);
        model.addAttribute("marketNews", marketNewsController.displayMarketNews());

        return "home/index";
    }
}
