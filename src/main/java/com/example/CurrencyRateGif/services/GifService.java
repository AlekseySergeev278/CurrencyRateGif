package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.models.Gif;
import com.example.CurrencyRateGif.models.HistoryCurrencyRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class GifService {

    JsonService jsonService = new JsonService();
    HistoryCurrencyRateService historyCurrencyRateService = new HistoryCurrencyRateService();

    public Gif getGif(JsonNode jsonNode, String pattern){
        String url = jsonNode.get("data").get("images").get("downsized_large").get("url").asText();
        return new Gif(pattern, url);
    }

    public String getGifLink(String currency) throws JsonProcessingException {
        HistoryCurrencyRate historyCurrencyRate = historyCurrencyRateService.getHistoryCurrencyRate(currency);
        String pattern = historyCurrencyRateService.getRichOrBrokeOrNoProblem(historyCurrencyRate);

        JsonNode jsonGif = jsonService.getJsonGif(pattern);

        return getGif(jsonGif, pattern).getUrl();
    }
}
