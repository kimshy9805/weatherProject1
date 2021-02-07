package com.kay.weather.model;


import javax.persistence.*;

@Entity(name = "weather_city")
@Table
public class City {
    @Id
    @Column(name="id")
    @SequenceGenerator(
            name = "weather_sequence",
            sequenceName = "weather_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "weather_sequence"
    )
    private Long id;

    @Column(
            name = "city_id",
            nullable = false,
            unique = true
    )
    private Integer cityId;

    @Column(
            name = "city_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String cityName;

    @Column(
            name = "state",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String state;

    @Column(
            name = "country",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String country;

    @Column(
            name = "Longtutide"
    )
    private Double Longtitude;

    @Column(
            name = "Latitude"
    )
    private Double Latitude;

    public City(Integer cityId, String cityName, String state, String country, Double longtitude, Double latitude) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.state = state;
        this.country = country;
        Longtitude = longtitude;
        Latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLongtitude() {
        return Longtitude;
    }

    public void setLongtitude(Double longtitude) {
        Longtitude = longtitude;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }
}
