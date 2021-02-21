package com.kay.weather.model;

public class OpenWeatherMap {
    /*
        URLs and parameters for OWM.org
    */
    private static final String API_KEY = "320044c0cf7b1d685ff79af4bff6bb97";
    private static final String URL_API = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String URL_CURRENT = "weather?";
    private static final String URL_HOURLY_FORECAST = "forecast?";
    private static final String URL_DAILY_FORECAST = "forecast/daily?";

    private static final String PARAM_COUNT = "cnt=";
    private static final String PARAM_CITY_NAME = "q=";
    private static final String PARAM_CITY_ID = "id=";
    private static final String PARAM_LATITUDE = "lat=";
    private static final String PARAM_LONGITUDE = "lon=";
    private static final String PARAM_MODE = "mode=";
    private static final String PARAM_UNITS = "units=";
    private static final String PARAM_APPID = "appId=";
    private static final String PARAM_LANG = "unit=";

    /*
        Instance Variables
    */
    private String cityId;
    private String unit;



    /*
        Constructor
    */



    public static String getUrlApi() {
        return URL_API;
    }

    public String getCityId() {
        return cityId;
    }

    public String getUnit() {
        return unit;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

