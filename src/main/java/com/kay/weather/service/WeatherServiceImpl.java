package com.kay.weather.service;

import com.kay.weather.model.City;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private final CityRepository cityRepository;

    public WeatherServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Optional<City> findCityIdByCityName(String cityName) {
        return cityRepository.findCityByCityId(cityName);
    }

}
