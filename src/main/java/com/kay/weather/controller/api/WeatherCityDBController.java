package com.kay.weather.controller.api;

import com.kay.weather.model.ApiVariable;
import com.kay.weather.model.City;
import com.kay.weather.service.DBServiceImpl;
import com.kay.weather.service.OpenWeatherService;
import com.kay.weather.service.OpenWeatherServiceImpl;
import com.kay.weather.service.DBServiceImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

//Request param => extract from query string
//path variable -> extract from URI
//still they extract data from URI
//UI에서 필요한 부분.

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherCityDBController {

    private final DBServiceImpl DBService;
    // private final ApplicationContext context;
   // private final Function<ApiVariable, Object> factory;

    @Autowired
    public WeatherCityDBController(DBServiceImpl weatherService) {
        this.DBService = weatherService;
       // this.factory = factory;
        //   this.context = context;
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
    @PostMapping(path = "apiSet")
    public void registarApiVariable(@RequestBody @Validated JSONObject test) throws ParseException {
        System.out.println(test);
        OpenWeatherServiceImpl t1 = new OpenWeatherServiceImpl(test);
        System.out.println(t1.getURL());
    }

}
