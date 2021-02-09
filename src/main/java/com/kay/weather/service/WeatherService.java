package com.kay.weather.service;


import com.kay.weather.model.City;

import java.util.Optional;

public interface WeatherService {
    Optional<City> findCityIdByCityName(String cityName);
}
