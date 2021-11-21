package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.AppConfig;
import com.example.CurrencyRateGif.interfaces.Giphy;
import com.example.CurrencyRateGif.interfaces.Openexchangerates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;

public class JsonService {

    AppConfig appConfig = new AppConfig();

    public JsonNode getJsonCurrencyRate(String date) throws JsonProcessingException {
        Openexchangerates openexchangerates = Feign.builder().target(Openexchangerates.class, appConfig.getOpenexchangeratesURL());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(openexchangerates.getExchangeRate(date,
                appConfig.getQueryMapOpenexchangerates()));

        return jsonNode;
    }

    public JsonNode getJsonGif(String pattern) throws JsonProcessingException {
        appConfig.getQueryMapGiphy().put("tag", pattern);

        Giphy giphy = Feign.builder().target(Giphy.class, appConfig.getGiphyURL());
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(giphy.getGifRel(appConfig.getQueryMapGiphy()));

        return jsonNode;
    }
}
