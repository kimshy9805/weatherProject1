package com.kay.weather.controller.api;

import com.kay.weather.model.City;
import com.kay.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherController {

    private final WeatherServiceImpl weatherService;

    @Autowired
    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<City> showAllCity() {
        return weatherService.showAllCity();
    }

    // TODO: 11/02/2021 getmapping으로 city id 랑 city name list return하는 방법 찾아보기
    //Request param => extract from query string
    //path variable -> extract from URI
    //still they extract data from URI
    @GetMapping(path = "/api/v1/weather/name/{cityName}")
    @ResponseBody
    public String getIdByName(@PathVariable String cityName) {
        return weatherService.findCityIdByCityName(cityName);
    }

    @GetMapping(path = "/api/v1/weather/country/{country}")
    public List<City> getNameByCountry(@PathVariable String country) {
        return weatherService.getCityByCountry(country);
    }
}
