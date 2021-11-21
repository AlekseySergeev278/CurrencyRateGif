package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.models.CurrencyRate;
import com.fasterxml.jackson.databind.JsonNode;

public class CurrencyRateService {

    public CurrencyRate getCurrencyRate(JsonNode jsonNode, String currency, String date) {
        double value = jsonNode.get("rates").get(currency).asDouble();

        return new CurrencyRate(currency, date, value);
    }

}
