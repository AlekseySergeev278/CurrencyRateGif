package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.models.CurrencyRate;
import com.example.CurrencyRateGif.models.HistoryCurrencyRate;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryCurrencyRateService {

    CurrencyRateService currencyRateService = new CurrencyRateService();
    JsonService jsonService = new JsonService();

    public HistoryCurrencyRate getHistoryCurrencyRate(String currency) throws JsonProcessingException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String yesterday = dtf.format(now.minusDays(1));
        String today = dtf.format(now);

        CurrencyRate currencyRateYesterday = currencyRateService.getCurrencyRate(jsonService.getJsonCurrencyRate(yesterday), currency, yesterday);
        CurrencyRate currencyRateToday = currencyRateService.getCurrencyRate(jsonService.getJsonCurrencyRate(today), currency, today);

        return new HistoryCurrencyRate(currencyRateYesterday, currencyRateToday);
    }

    public String getRichOrBrokeOrNoProblem(HistoryCurrencyRate historyCurrencyRate) {
        double yesterdayCurrency = historyCurrencyRate.getYesterdayCurrencyRate().getValue();
        double todayCurrency = historyCurrencyRate.getTodayCurrencyRate().getValue();

        return todayCurrency == yesterdayCurrency ? "no-problem": todayCurrency > yesterdayCurrency ?"rich" : "broke";
    }
}
