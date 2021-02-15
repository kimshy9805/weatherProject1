package com.kay.weather.controller.api;

import com.kay.weather.model.OpenWeatherMap;
import com.kay.weather.service.DBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.kay.weather.model.OpenWeatherMap.getApiKey;

//실제 open weather api controller

// TODO: 12/02/2021 실제로 사용해서 weathercontroller하고 연동하는곳.  

@RestController
//@RequestMapping(path = "api.openweathermap.org/data/2.5/weather?")
@RequestMapping
public class OpenWeatherApi {
//
//    private final ApiVariable variable;
//    private final WeatherServiceImpl weatherService;

//    @Autowired
//    public OpenWeatherApi(ApiVariable variable, WeatherServiceImpl weatherService) {
//        this.variable = variable;
//        this.weatherService = weatherService;
//        System.out.println("Apivarialbe initialized");
//    }

//    @GetMapping
//    public String getWeatherInfo() {
//        return weatherService.getURI("metric", "Busan");
//    }




}
