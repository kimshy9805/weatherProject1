package com.kay.weather.service;

import com.kay.weather.model.OpenWeatherMap;
import com.kay.weather.model.City;
import com.kay.weather.model.CityDTO;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBServiceImpl implements DBService {

    /////////////////////////////////////////
    //           DB-related service
    ////////////////////////////////////////

    private final CityRepository cityRepository;
    //configuration에서 bean initialized되면 모든 di부분에서 바로 인젝이 되는드샇ㅁ.
   // private final ApiVariable apiVariable;
//
//    @Autowired
//    public WeatherServiceImpl(CityRepository cityRepository, ApiVariable apiVariable) {
//        System.out.println("ddddd");
//        this.cityRepository = cityRepository;
//        this.apiVariable = apiVariable;
//    }

    @Autowired
    public DBServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> showAllCity() {
        return cityRepository.findAll();
    }

    //**
    @Override
    public String findCityIdByCityName(String cityName) {
        return cityRepository.findCityIdByCityName(cityName);
    }

    //**
    @Override
    public List<String> getCountryList() {
        return cityRepository.getCountryList();
    }

    //list all city name
    @Override
    public List<String> getCityByCountry(String country) {
        return cityRepository.getCityByCountry(country);
    }

    //return citylist info
    @Override
    public List<City> getCityListByCountry(String country) {
        return cityRepository.getCityListByCountry(country);
    }

}
