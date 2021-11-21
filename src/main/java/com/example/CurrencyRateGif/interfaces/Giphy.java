package com.example.CurrencyRateGif.interfaces;

import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface Giphy {

    @RequestLine("GET /v1/gifs/random")
    String getGifRel(@QueryMap Map<String, String> queryMap);
}
