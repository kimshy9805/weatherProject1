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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import static com.kay.weather.model.OpenWeatherMap.getApiKey;


@RestController
@RequestMapping(path = "api/v1/owm")
public class OpenWeatherMapController {
    private final RestTemplate restTemplate;

    @Autowired
    public OpenWeatherMapController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //return JSON object for specific weather info
    @GetMapping(path = "/retrieve")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public WeatherInfo retrieveWeatherData(@RequestBody @Validated JSONObject test) throws ParseException {
        OpenWeatherServiceImpl t1 = new OpenWeatherServiceImpl(test);
        String URL = t1.getURL();

        WeatherInfo weatherInfo = restTemplate.getForObject(URL, WeatherInfo.class);

        return weatherInfo;
    }






}
