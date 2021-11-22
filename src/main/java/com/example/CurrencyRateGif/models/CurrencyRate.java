package com.example.CurrencyRateGif.models;

import java.util.Objects;

/**
 * This class represents an object with currency rate
 */

public class CurrencyRate {
    private String currency;
    private String date;
    private double value;


    public CurrencyRate(String currency, String date, double value) {
        this.currency = currency;
        this.date = date;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyRate currencyRate = (CurrencyRate) o;
        return Double.compare(currencyRate.value, value) == 0 && Objects.equals(currency, currencyRate.currency) && Objects.equals(date, currencyRate.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, date, value);
    }
}
