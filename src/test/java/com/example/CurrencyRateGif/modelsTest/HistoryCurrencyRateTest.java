package com.example.CurrencyRateGif.modelsTest;

import com.example.CurrencyRateGif.models.HistoryCurrencyRate;
import com.example.CurrencyRateGif.models.CurrencyRate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HistoryCurrencyRateTest {


    @Test
    public void getTodayRateTest(){
        CurrencyRate yesterdayCurrencyRateMock = mock(CurrencyRate.class);
        CurrencyRate todayCurrencyRateMock = mock(CurrencyRate.class);
        HistoryCurrencyRate historyCurrencyRate = new HistoryCurrencyRate(yesterdayCurrencyRateMock, todayCurrencyRateMock);
        when(todayCurrencyRateMock.getValue()).thenReturn(51.4);
        assertEquals(51.4, historyCurrencyRate.getTodayCurrencyRate().getValue(), 1e-9);
    }

    @Test
    public void getYesterdayRateTest(){
        CurrencyRate yesterdayCurrencyRateMock = mock(CurrencyRate.class);
        CurrencyRate todayCurrencyRateMock = mock(CurrencyRate.class);
        HistoryCurrencyRate historyCurrencyRate = new HistoryCurrencyRate(yesterdayCurrencyRateMock, todayCurrencyRateMock);
        when(yesterdayCurrencyRateMock.getValue()).thenReturn(52.4);
        assertEquals(52.4, historyCurrencyRate.getYesterdayCurrencyRate().getValue(), 1e-9);
    }
}
