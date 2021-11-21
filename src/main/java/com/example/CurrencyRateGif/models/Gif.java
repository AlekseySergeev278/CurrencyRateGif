package com.example.CurrencyRateGif.models;

import java.util.Objects;

public class Gif {

    private String pattern;
    private String url;

    public Gif(String pattern, String url) {
        this.pattern = pattern;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gif gif = (Gif) o;
        return Objects.equals(pattern, gif.pattern) && Objects.equals(url, gif.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, url);
    }
}
