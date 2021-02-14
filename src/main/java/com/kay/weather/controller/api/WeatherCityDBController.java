package com.kay.weather.controller.api;

import com.kay.weather.model.ApiVariable;
import com.kay.weather.model.City;
import com.kay.weather.service.WeatherServiceImpl;
import com.kay.weather.config.Config;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

//Request param => extract from query string
//path variable -> extract from URI
//still they extract data from URI
//UI에서 필요한 부분.

@RestController
@RequestMapping(path = "api/v1/weather")
public class WeatherCityDBController {

    private final WeatherServiceImpl weatherService;
    private final BeanFactory factory;

    @Autowired
    public WeatherCityDBController(WeatherServiceImpl weatherService, BeanFactory factory) {
        this.weatherService = weatherService;
        this.factory = factory;
    }

    //get country list
    @GetMapping
    public List<String> getCountryList() {
        return weatherService.getCountryList();
    }

    //get city list info (lat,lon) by specific country
    @GetMapping(path = "country/list/{country}")
    public List<City> getCityListByCountry(@PathVariable("country") String country) {
        return weatherService.getCityListByCountry(country);
    }

    //get cityname list by country
    @GetMapping(path = "country/{country}")
    public List<String> getNameByCountry(@PathVariable("country") String country) {
        return weatherService.getCityByCountry(country);
    }

    //get city id by city name
    @GetMapping(path = "{cityName}")
    public String getIdByName(@PathVariable("cityName") String cityName) {
        return weatherService.findCityIdByCityName(cityName);
    }

    //requestbody에서 apivariable 넣고
    //bean에다가 initialize
    @PostMapping(path = "apiSet")
    //바로 bean initialized가 되네
    public void registarApiVariable(@RequestBody @Validated ApiVariable apiVariable) {
        //factory.getBean(String.valueOf(test));
        System.out.println(apiVariable.getCityId() +" " + apiVariable.getUnit());
        weatherService.CreateApiVariable(apiVariable);





        System.out.println(weatherService.getURI());
    }

    @GetMapping(path = "apiSet/re")
    public String getApiUrl() {
        return weatherService.getURI();
    }
    //final ApiVariable apiVariable = (ApiVariable) myPrototypeProvider.getObject(test);

}
