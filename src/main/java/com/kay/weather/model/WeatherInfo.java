package com.kay.weather.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Serializable;

// TODO: 15/02/2021 이제는 jsonobject와 jsonarray값을 저장하는 방법  

public class WeatherInfo implements Serializable {
    //cannot have final attributes -> need default constructor

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


    public WeatherInfo() {

    };

    @Override
    public String toString() {
        return "Practice{" +
                "base='" + base + '\'' +
                ", visibility='" + visibility + '\'' +
                ", id='" + id + '\'' +
                ", coord=" + coord +
                ", weather=" + weather +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", sys=" + sys +
                ", timezone='" + timezone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public WeatherInfo(String base, String visibility, String id, JSONObject coord, JSONArray weather, JSONObject main, JSONObject wind, JSONObject clouds, JSONObject sys, String timezone, String name) {
        this.base = base;
        this.visibility = visibility;
        this.id = id;
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.sys = sys;
        this.timezone = timezone;
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONObject getCoord() {
        return coord;
    }

    public void setCoord(JSONObject coord) {
        this.coord = coord;
    }

    public JSONArray getWeather() {
        return weather;
    }

    public void setWeather(JSONArray weather) {
        this.weather = weather;
    }

    public JSONObject getMain() {
        return main;
    }

    public void setMain(JSONObject main) {
        this.main = main;
    }

    public JSONObject getWind() {
        return wind;
    }

    public void setWind(JSONObject wind) {
        this.wind = wind;
    }

    public JSONObject getClouds() {
        return clouds;
    }

    public void setClouds(JSONObject clouds) {
        this.clouds = clouds;
    }

    public JSONObject getSys() {
        return sys;
    }

    public void setSys(JSONObject sys) {
        this.sys = sys;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
