package com.kay.weather.model;

import lombok.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Serializable;

@Data
public class WeatherInfo implements Serializable {
    private String base;
    private String visibility;
    private String id;
    private JSONObject coord;
    private JSONArray weather;
    private JSONObject main;
    private JSONObject wind;
    private JSONObject clouds;
    private JSONObject sys;
    private String timezone;
    private String name;

}
