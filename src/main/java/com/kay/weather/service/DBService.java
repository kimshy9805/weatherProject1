package com.kay.weather.service;


import com.kay.weather.model.OpenWeatherMap;
import com.kay.weather.model.City;

import java.util.List;
import java.util.Optional;

public interface DBService {
    String findCityIdByCityName(String cityName);

    List<City> showAllCity();

    List<String> getCountryList();

    List<City> getCityInfoByCountry(String country);

    List<String> getCityListByCountry(String country);

}
