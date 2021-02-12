package com.kay.weather.controller.api;

import com.kay.weather.model.City;
import com.kay.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;
import java.util.List;
import java.util.Optional;

//Request param => extract from query string
//path variable -> extract from URI
//still they extract data from URI
//UI에서 필요한 부분.

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherCityDBController {

    private final WeatherServiceImpl weatherService;

    @Autowired
    public WeatherCityDBController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    //get country list
    @GetMapping
    public List<String> getCountryList() {
        return weatherService.getCountryList();
    }

    //get city list info (lat,lon) by specific country
    @GetMapping(path = "country/list/{country}")
    public List<City> getCityListByCountry(@PathVariable("country") String country) {
        return weatherService.getCityListByCountry(country);
    }

    //get cityname list by country
    @GetMapping(path = "country/{country}")
    public List<String> getNameByCountry(@PathVariable("country") String country) {
        return weatherService.getCityByCountry(country);
    }

    //get city id by city name
    @GetMapping(path = "{cityName}")
    public String getIdByName(@PathVariable("cityName") String cityName) {
        return weatherService.findCityIdByCityName(cityName);
    }

}
