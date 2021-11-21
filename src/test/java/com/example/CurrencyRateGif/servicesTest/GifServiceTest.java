package com.example.CurrencyRateGif.servicesTest;

import com.example.CurrencyRateGif.models.Gif;
import com.example.CurrencyRateGif.services.GifService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

public class GifServiceTest {

    @Test // Testing getGif method
    public void shouldBeEqual(){
        GifService gifService = new GifService();

        String pattern = "rich";
        String url = "shttps://media3.giphy.com/media/Ret4xPds9ja38xJaih/giphy.gif?cid=aeca6e4c6bc6e5d33d1c6f2a385e12a070f2968c40d3cce5&rid=giphy.gif&ct=g";
        Gif gif = new Gif(pattern, url);

        JsonNode jsonNodeMock1 = mock(JsonNode.class);
        JsonNode jsonNodeMock2 = mock(JsonNode.class);
        JsonNode jsonNodeMock3 = mock(JsonNode.class);
        JsonNode jsonNodeMock4 = mock(JsonNode.class);
        JsonNode jsonNodeMock5 = mock(JsonNode.class);

        when(jsonNodeMock1.get("data")).thenReturn(jsonNodeMock2);
        when(jsonNodeMock2.get("images")).thenReturn(jsonNodeMock3);
        when(jsonNodeMock3.get("downsized_large")).thenReturn(jsonNodeMock4);
        when(jsonNodeMock4.get("url")).thenReturn(jsonNodeMock5);
        when(jsonNodeMock5.asText()).thenReturn(url);

        assertEquals(gif, gifService.getGif(jsonNodeMock1, pattern));
    }

    @Test // Testing getGif method
    public void shouldNotBeEqual(){
        GifService gifService = new GifService();

        String pattern = "rich";
        String url1 = "shttps://media3.giphy.com/media/Ret4xPds9ja38xJaih/giphy.gif?cid=aeca6e4c6bc6e5d33d1c6f2a385e12a070f2968c40d3cce5&rid=giphy.gif&ct=g";
        String url2 = "shttps://media3.giphy.com";
        Gif gif = new Gif(pattern, url1);

        JsonNode jsonNodeMock1 = mock(JsonNode.class);
        JsonNode jsonNodeMock2 = mock(JsonNode.class);
        JsonNode jsonNodeMock3 = mock(JsonNode.class);
        JsonNode jsonNodeMock4 = mock(JsonNode.class);
        JsonNode jsonNodeMock5 = mock(JsonNode.class);

        when(jsonNodeMock1.get("data")).thenReturn(jsonNodeMock2);
        when(jsonNodeMock2.get("images")).thenReturn(jsonNodeMock3);
        when(jsonNodeMock3.get("downsized_large")).thenReturn(jsonNodeMock4);
        when(jsonNodeMock4.get("url")).thenReturn(jsonNodeMock5);
        when(jsonNodeMock5.asText()).thenReturn(url2);

        assertNotEquals(gif, gifService.getGif(jsonNodeMock1, pattern));
    }

    @Test
    public void getGifLinkTest() throws JsonProcessingException {
        String currency = "RUB";
        GifService gifService = new GifService();
        assertNotNull(gifService.getGifLink(currency));
    }
}
