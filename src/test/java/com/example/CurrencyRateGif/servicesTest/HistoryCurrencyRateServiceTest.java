package com.example.CurrencyRateGif.servicesTest;

import com.example.CurrencyRateGif.models.CurrencyRate;
import com.example.CurrencyRateGif.models.HistoryCurrencyRate;
import com.example.CurrencyRateGif.services.HistoryCurrencyRateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HistoryCurrencyRateServiceTest {

    @Test
    public void getHistoryCurrencyRate() throws JsonProcessingException {
        HistoryCurrencyRateService historyCurrencyRateService = new HistoryCurrencyRateService();

        historyCurrencyRateService.getHistoryCurrencyRate("RUB");
        assertNotNull(historyCurrencyRateService.getHistoryCurrencyRate("RUB"));
    }

    @Test //Test method getRichOrBrokeOrNoProblem from HistoryCurrencyRate.class
    public void shouldReturnRich() {
        HistoryCurrencyRateService historyCurrencyRateService = new HistoryCurrencyRateService();
        CurrencyRate currencyRate1 = new CurrencyRate("RUB", "2021-11-14", 65.4);
        CurrencyRate currencyRate2 = new CurrencyRate("RUB", "2021-11-15", 66.4);
        HistoryCurrencyRate historyCurrencyRate = new HistoryCurrencyRate(currencyRate1, currencyRate2);
        assertEquals("rich", historyCurrencyRateService.getRichOrBrokeOrNoProblem(historyCurrencyRate));
    }
}
