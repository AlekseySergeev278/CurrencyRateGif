package com.example.CurrencyRateGif.models;

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
