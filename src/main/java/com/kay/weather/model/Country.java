package com.kay.weather.model;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private List<String> country = new ArrayList<>();

    public Country(List<String> country) {
        this.country = country;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }
}
