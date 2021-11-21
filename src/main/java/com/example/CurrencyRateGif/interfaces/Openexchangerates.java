package com.example.CurrencyRateGif.interfaces;


import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface Openexchangerates {

    @RequestLine("GET /api/historical/{date}.json")
    String getExchangeRate(@Param("date") String date, @QueryMap Map<String, String> queryMap);
}
