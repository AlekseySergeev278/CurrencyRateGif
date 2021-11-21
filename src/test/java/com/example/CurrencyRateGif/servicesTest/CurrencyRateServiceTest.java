package com.example.CurrencyRateGif.servicesTest;

import com.example.CurrencyRateGif.models.CurrencyRate;
import com.example.CurrencyRateGif.services.CurrencyRateService;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyRateServiceTest {

    @Test
    public void getCurrencyRateTest(){
        CurrencyRateService currencyRateService = new CurrencyRateService();

        JsonNode jsonNodeMock1 = mock(JsonNode.class);
        JsonNode jsonNodeMock2 = mock(JsonNode.class);
        JsonNode jsonNodeMock3 = mock(JsonNode.class);

        String currency = "RUB";
        String date = "2021-11-15";
        double value = 43.5;


        when(jsonNodeMock1.get("rates")).thenReturn(jsonNodeMock2);
        when(jsonNodeMock2.get(currency)).thenReturn(jsonNodeMock3);
        when(jsonNodeMock3.asDouble()).thenReturn(43.5);

        CurrencyRate currencyRate1 = new CurrencyRate(currency, date, value);
        CurrencyRate currencyRate2 = currencyRateService.getCurrencyRate(jsonNodeMock1, currency, date);
        assertEquals(currencyRate1, currencyRate2);

    }
}
