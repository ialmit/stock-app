package com.timlai.stockapp.controller;

import com.timlai.stockapp.entity.StockAppUser;
import com.timlai.stockapp.repository.StockAppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    BCryptPasswordEncoder passwordEncoder;
    StockAppUserRepository stockAppUserRepository;

    public SecurityController(BCryptPasswordEncoder passwordEncoder, StockAppUserRepository stockAppUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.stockAppUserRepository = stockAppUserRepository;
    }

    @GetMapping("/register")
    public String register(Model model){
        StockAppUser stockAppUser = new StockAppUser();
        model.addAttribute("stockAppUser",stockAppUser);

        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, StockAppUser stockAppUser){
        stockAppUser.setUserPassword(passwordEncoder.encode(stockAppUser.getUserPassword()));
        stockAppUserRepository.save(stockAppUser);

        return "redirect:/";
    }
}
