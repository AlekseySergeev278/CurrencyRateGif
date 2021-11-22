package com.example.CurrencyRateGif.models;

/**
 * This class represents an object with rate with special currency for the last two days
 */

public class HistoryCurrencyRate {
    private CurrencyRate yesterdayCurrencyRate;
    private CurrencyRate todayCurrencyRate;

    public HistoryCurrencyRate(CurrencyRate yesterdayCurrencyRate, CurrencyRate todayCurrencyRate) {
        this.yesterdayCurrencyRate = yesterdayCurrencyRate;
        this.todayCurrencyRate = todayCurrencyRate;
    }

    public CurrencyRate getTodayCurrencyRate() {
        return todayCurrencyRate;
    }


    public CurrencyRate getYesterdayCurrencyRate() {
        return yesterdayCurrencyRate;
    }

}
