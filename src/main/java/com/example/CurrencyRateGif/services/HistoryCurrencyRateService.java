package com.example.CurrencyRateGif.services;

import com.example.CurrencyRateGif.models.CurrencyRate;
import com.example.CurrencyRateGif.models.HistoryCurrencyRate;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryCurrencyRateService {

    CurrencyRateService currencyRateService = new CurrencyRateService();
    JsonService jsonService = new JsonService();

    /**
     * This method gets String with interesting currency and invokes other method in order to give a HistoryCurrencyRate object
     * @param currency - String with interesting currency
     * @return HistoryCurrencyRate object which includes two CurrencyRate objects
     * @throws JsonProcessingException
     */
    public HistoryCurrencyRate getHistoryCurrencyRate(String currency) throws JsonProcessingException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String yesterday = dtf.format(now.minusDays(1));
        String today = dtf.format(now);

        CurrencyRate currencyRateYesterday = currencyRateService.getCurrencyRate(jsonService.getJsonCurrencyRate(yesterday), currency, yesterday);
        CurrencyRate currencyRateToday = currencyRateService.getCurrencyRate(jsonService.getJsonCurrencyRate(today), currency, today);

        return new HistoryCurrencyRate(currencyRateYesterday, currencyRateToday);
    }

    /**
     * This method gets HistoryCurrencyRate object and compares rate for two days. If exchange rate's increased you get "rich" pattern, if it's fell
     * you get "broke" pattern, else you get "no-problem" pattern
     * @param historyCurrencyRate - you can get this historyCurrencyRate object using getHistoryCurrencyRate method from HistoryCurrencyRateService module
     * @return String with pattern
     */
    public String getRichOrBrokeOrNoProblem(HistoryCurrencyRate historyCurrencyRate) {
        double yesterdayCurrency = historyCurrencyRate.getYesterdayCurrencyRate().getValue();
        double todayCurrency = historyCurrencyRate.getTodayCurrencyRate().getValue();

        return todayCurrency == yesterdayCurrency ? "no-problem": todayCurrency > yesterdayCurrency ?"rich" : "broke";
    }
}
