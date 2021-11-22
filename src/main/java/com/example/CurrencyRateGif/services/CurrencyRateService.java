package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.models.CurrencyRate;
import com.fasterxml.jackson.databind.JsonNode;

public class CurrencyRateService {

    /**
     * This method parses json and generates a CurrencyRate object with data/
     * @param jsonNode - you can get a JsonNode object using getJsonCurrencyRate method from JsonService module
     * @param currency - it means special currency what you wish to see
     * @param date - write a day for which currency you want to see
     * @return CurrencyRate object
     */
    public CurrencyRate getCurrencyRate(JsonNode jsonNode, String currency, String date) {
        double value = jsonNode.get("rates").get(currency).asDouble();

        return new CurrencyRate(currency, date, value);
    }

}
