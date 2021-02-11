package com.kay.weather.service;


import com.kay.weather.model.City;

import java.util.List;
import java.util.Optional;

public interface WeatherService {
    String findCityIdByCityName(String cityName);

    List<City> showAllCity();

    List<City> getCityByCountry(String country);

}
