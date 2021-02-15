package com.kay.weather.model;

import javax.persistence.*;

@Entity(name = "weather_city")
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(
            name = "city_id",
            nullable = false
    )
    private String cityId;

    @Column(
            name = "city_name",
            nullable = false
    )
    private String cityName;

    @Column(
            name = "country",
            nullable = false
    )
    private String country;

    @Column(
            name = "coord",
            nullable = false
    )
    private String coord;

    public City() {
    }

    public City(String cityId, String cityName, String country, String coord) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.country = country;
        this.coord = coord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }
}
