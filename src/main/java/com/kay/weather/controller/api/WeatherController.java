package com.kay.weather.controller.api;

import com.kay.weather.model.Area;
import com.kay.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherController {

    @Autowired
    private final WeatherServiceImpl weatherService;

    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }

//    @GetMapping
//    public List<Area> getForecastArea(String area) {
//        return weatherService.getForecastArea(area);
//    }





}
