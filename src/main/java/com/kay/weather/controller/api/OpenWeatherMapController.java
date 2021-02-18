package com.kay.weather.controller.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kay.weather.model.OpenWeatherMap;
import com.kay.weather.model.WeatherInfo;
import com.kay.weather.service.DBServiceImpl;
import com.kay.weather.service.OpenWeatherServiceImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.kay.weather.model.OpenWeatherMap.getApiKey;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/owm")
public class OpenWeatherMapController {
    private final RestTemplate restTemplate;
    private final DBServiceImpl DBService;
    private final OpenWeatherServiceImpl openWeatherService;

    @Autowired
    public OpenWeatherMapController(RestTemplate restTemplate, DBServiceImpl DBService, OpenWeatherServiceImpl openWeatherService) {
        this.restTemplate = restTemplate;
        this.DBService = DBService;
        this.openWeatherService = openWeatherService;
    }

    //return JSON object for specific weather info
    //get requestbody를 바꾸면될
//    @GetMapping(path = "/retrieve/{cityName}")
//    @JsonIgnoreProperties(ignoreUnknown = true)
//    public WeatherInfo retrieveWeatherData(@RequestBody @Validated JSONObject test) throws ParseException {
//        OpenWeatherServiceImpl t1 = new OpenWeatherServiceImpl(test);
//        String URL = t1.getURL();
//
//        WeatherInfo weatherInfo = restTemplate.getForObject(URL, WeatherInfo.class);
//
//        return weatherInfo;
//    }

    //Service layer를 통해서 List<WeatherInfo> 만을 return해야함
    @GetMapping(path = "/retrieve/{cityName}")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public List<WeatherInfo> retrieveWeatherData(@PathVariable("cityName") @Validated String test) throws ParseException {
        return openWeatherService.getWeatherInfo(test);
    }






}
