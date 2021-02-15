package com.kay.weather.service;


import com.kay.weather.model.ApiVariable;
import com.kay.weather.model.City;

import java.util.List;
import java.util.Optional;

public interface DBService {
    String findCityIdByCityName(String cityName);

    List<City> showAllCity();

    List<String> getCountryList();

    List<String> getCityByCountry(String country);

    List<City> getCityListByCountry(String country);

}
