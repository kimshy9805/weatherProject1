package com.kay.weather.service;

import com.kay.weather.model.WeatherInfo;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.List;

public interface OpenWeatherService {

    String getURL(String cityId);

    List<WeatherInfo> getWeatherInfo(String CityId);

    HashMap<String, String> parseApiVariable(JSONObject test) throws ParseException;
}
