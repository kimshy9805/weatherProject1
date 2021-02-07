package com.kay.weather.model;


import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Getter
//@Setter

//
//@Entity
//@Table
public class Area {

    private Long id;
    private String area;
    private Long latitude;
    private Long longitude;
    private String forecastState;

    public Area(Long id, String area, Long latitude, Long longitude, String forecastState) {
        this.id = id;
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
        this.forecastState = forecastState;
    }

    public Area(String area, Long latitude, Long longitude, String forecastState) {
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
        this.forecastState = forecastState;
    }

    public Area() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getForecastState() {
        return forecastState;
    }

    public void setForecastState(String forecastState) {
        this.forecastState = forecastState;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
