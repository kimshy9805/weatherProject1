package com.kay.weather.service;

import com.kay.weather.model.Area;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {


    @Autowired
    private final CityRepository cityRepository;

    public WeatherServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }



//    @Override
//    public List<Area> getForecastArea(String area) {
//        return cityRepository.findAll();
//    }



}
