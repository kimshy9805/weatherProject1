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

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/owm")
public class OpenWeatherMapController {

    @Autowired
    private OpenWeatherServiceImpl openWeatherService;

    @GetMapping(path = "/retrieve/{cityName}")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public List<WeatherInfo> retrieveWeatherData(@PathVariable("cityName") @Validated String cityName) throws ParseException {
        return openWeatherService.getWeatherInfo(cityName);
    }

}
