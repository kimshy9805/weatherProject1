package com.kay.weather.controller.api;

import com.kay.weather.model.City;
import com.kay.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.Area;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherController {

    @Autowired
    private final WeatherServiceImpl weatherService;

    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "cityName")
    public Optional<City> findCityIdByCityName(@PathVariable("cityName") String cityName) {
        return weatherService.findCityIdByCityName(cityName);
    }





}
