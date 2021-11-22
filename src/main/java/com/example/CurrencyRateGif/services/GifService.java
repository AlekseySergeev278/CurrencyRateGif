package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.models.Gif;
import com.example.CurrencyRateGif.models.HistoryCurrencyRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class GifService {

    JsonService jsonService = new JsonService();
    HistoryCurrencyRateService historyCurrencyRateService = new HistoryCurrencyRateService();

    /**
     * This method parses json and generates a Gif object with data/
     * @param jsonNode - you can get a JsonNode object using getJsonGif method from JsonService module
     * @param pattern - you can get this pattern using getRichOrBrokeOrNoProblem method from HistoryCurrencyRateService module or write what you're interesting
     * @return GIf object with data
     */
    public Gif getGif(JsonNode jsonNode, String pattern){
        String url = jsonNode.get("data").get("images").get("downsized_large").get("url").asText();
        return new Gif(pattern, url);
    }

    /**
     * This method gets String with interesting currency and invokes other method in order to give a String with url
     * @param currency - String with interesting currency
     * @return String with url
     * @throws JsonProcessingException
     */
    public String getGifLink(String currency) throws JsonProcessingException {
        HistoryCurrencyRate historyCurrencyRate = historyCurrencyRateService.getHistoryCurrencyRate(currency);
        String pattern = historyCurrencyRateService.getRichOrBrokeOrNoProblem(historyCurrencyRate);

        JsonNode jsonGif = jsonService.getJsonGif(pattern);

        return getGif(jsonGif, pattern).getUrl();
    }
}
