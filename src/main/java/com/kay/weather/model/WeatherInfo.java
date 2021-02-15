package com.kay.weather.model;

import java.util.HashMap;

//inner class implement
public class WeatherInfo {
    private final String description = null;
    private final Integer timeZone = null;
    private HashMap<String, String> info = null;

    public WeatherInfo() {
    }

    //static enum to replace this.
    private class wind {
        private final Double speed;
        private final Integer degree;

        private wind(Double speed, Integer degree) {
            this.speed = speed;
            this.degree = degree;
        }
    }



    public String getDescription() {
        return description;
    }

    public HashMap<String, String> getInfo() {
        return info;
    }

    public void setInfo(HashMap<String, String> info) {
        this.info = info;
    }

    public Integer getTimeZone() {
        return timeZone;
    }
}
