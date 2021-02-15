package com.kay.weather.controller.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kay.weather.model.City;
import com.kay.weather.model.Practice;
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
@RequestMapping(path = "api/v1/weather")
public class WeatherCityDBController {

    private final DBServiceImpl DBService;

    @Autowired
    public WeatherCityDBController(DBServiceImpl weatherService) {
        this.DBService = weatherService;
    }

    //get country list
    @GetMapping
    public List<String> getCountryList() {
        return DBService.getCountryList();
    }

    //get city list info (lat,lon) by specific country
    @GetMapping(path = "country/list/{country}")
    public List<City> getCityListByCountry(@PathVariable("country") String country) {
        return DBService.getCityListByCountry(country);
    }

    //get cityname list by country
    @GetMapping(path = "country/{country}")
    public List<String> getNameByCountry(@PathVariable("country") String country) {
        return DBService.getCityByCountry(country);
    }

    //get city id by city name
    @GetMapping(path = "{cityName}")
    public String getIdByName(@PathVariable("cityName") String cityName) {
        return DBService.findCityIdByCityName(cityName);
    }

    //build apiVariable for open Waethear Api
    @GetMapping(path = "apiSet")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Practice registarApiVariable(@RequestBody @Validated JSONObject test) throws ParseException {
        OpenWeatherServiceImpl t1 = new OpenWeatherServiceImpl(test);
        String URL = t1.getURL();
        RestTemplate restTemplate = new RestTemplate();

        Practice practice = restTemplate.getForObject(URL, Practice.class);
        //이게 전체 Json을 받아오는것
        ResponseEntity<String> response
                = restTemplate.getForEntity(URL + "/1", String.class);

        //class pojo에 바로 넣을려면 respective한 class가 있어야함.
        return practice;
    }

}
