package com.kay.weather.service;

import com.kay.weather.model.City;
import com.kay.weather.repository.CityRepository;
import com.kay.weather.repository.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBServiceImpl implements DBService {

    /////////////////////////////////////////
    //           DB-related service
    ////////////////////////////////////////

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryDao countryDao;

    @Override
    public List<City> showAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public String findCityIdByCityName(String cityName) {
        return cityRepository.findCityIdByCityName(cityName);
    }

//    @Override
//    public List<String> getCountryList() {
//        return countryDao.retrieveCountryList();
//    }

    @Override
    public List<String> getCountryList() {
        return cityRepository.getCountryList();
    }

    @Override
    public List<String> getCityListByCountry(String country) {
        return cityRepository.getCityListByCountry(country);
    }

    @Override
    public List<City> getCityInfoByCountry(String country) {
        return cityRepository.getCityInfoByCountry(country);
    }

}
