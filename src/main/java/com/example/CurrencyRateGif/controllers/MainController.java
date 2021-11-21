package com.example.CurrencyRateGif.controllers;

import com.example.CurrencyRateGif.services.GifService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {


    GifService gifService = new GifService();

    @GetMapping("/{currency}")
    String home(@PathVariable("currency") String currency, Model model){
        try {
            model.addAttribute("gifLink", gifService.getGifLink(currency));
            return "page-with-gif";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "home";
    }


}
