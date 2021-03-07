package com.kay.weather.controller.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kay.weather.model.City;
import com.kay.weather.model.Country;
import com.kay.weather.model.WeatherInfo;
import com.kay.weather.service.DBServiceImpl;
import com.kay.weather.service.OpenWeatherServiceImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//Request param => extract from query string
//path variable -> extract from URI
//still they extract data from URI
//UI에서 필요한 부분.

@RestController
@RequestMapping(path = "api/v1/weather/")
public class WeatherDBController {

    @Autowired
    private DBServiceImpl DBService;

    @GetMapping(path = "country")
    public Country getCountryList() {
        return DBService.getCountryList();
    }

    //get city list by country
    @GetMapping(path = "country/{country}")
    public List<String> getCityListByCountry(@PathVariable("country") String country) {
        return DBService.getCityListByCountry(country);
    }

    //get city list info by specific country
    @GetMapping(path = "country/info/{country}")
    public List<City> getCityInfoByCountry(@PathVariable("country") String country) {
        return DBService.getCityInfoByCountry(country);
    }

    //get city id by city name
    @GetMapping(path = "{cityName}")
    public String getCityIdByName(@PathVariable("cityName") String cityName) {
        return DBService.findCityIdByCityName(cityName);
    }
}
