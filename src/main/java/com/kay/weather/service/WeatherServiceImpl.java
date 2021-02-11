package com.kay.weather.service;

import com.kay.weather.model.City;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final CityRepository cityRepository;

    @Autowired
    public WeatherServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> showAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public String findCityIdByCityName(String cityName) {
        return cityRepository.findCityIdByCityName(cityName);
    }

    @Override
    public List<City> getCityByCountry(String country) {
        return cityRepository.getCityByCountry(country);
    }
}
