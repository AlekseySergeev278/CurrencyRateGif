package com.example.CurrencyRateGif;



import java.util.HashMap;
import java.util.Map;


public class AppConfig {

    private String baseCurrency = "USD";

    private String openexchangeratesURL = "https://openexchangerates.org";
    private String giphyURL = "https://api.giphy.com";

    private Map<String, String> queryMapOpenexchangerates = new HashMap<>();
    private Map<String, String> queryMapGiphy = new HashMap<>();

    public AppConfig() {
        queryMapOpenexchangerates.put("app_id", "f56921d41fd143bab123d3a646bb89bb");
        queryMapGiphy.put("api_key", "jmOA2CuF07UwLpTifzvuwrKEzMSKZ5WP");
    }

    public String getOpenexchangeratesURL() {
        return openexchangeratesURL;
    }

    public String getGiphyURL() {
        return giphyURL;
    }

    public Map<String, String> getQueryMapOpenexchangerates() {
        return queryMapOpenexchangerates;
    }

    public Map<String, String> getQueryMapGiphy() {
        return queryMapGiphy;
    }

}
