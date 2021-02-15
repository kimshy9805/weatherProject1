package com.kay.weather.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.List;

public interface OpenWeatherService {

    String getURL();

    HashMap<String, String> parseApiVariable(JSONObject test) throws ParseException;
}
