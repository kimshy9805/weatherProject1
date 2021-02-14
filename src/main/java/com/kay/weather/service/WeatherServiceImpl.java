package com.kay.weather.service;

import com.kay.weather.model.ApiVariable;
import com.kay.weather.model.City;
import com.kay.weather.model.CityDTO;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final CityRepository cityRepository;
    private final ApiVariable apiVariable;

    @Autowired
    public WeatherServiceImpl(CityRepository cityRepository, ApiVariable apiVariable) {
        this.cityRepository = cityRepository;
        this.apiVariable = apiVariable;
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




    ///////////////////////////////////////
    ////     Non-Repository related
    //////////////////////////////////////

    // TODO: 12/02/2021 DTO fill up
    // TODO: 12/02/2021 URL 만들고 값 얻기 까지

    //안좋은것 db 와 interact하는것은 굉장히 expensive
    //그래서 db랑 interact한것은 store하는게 좋음.
    //알면서도 우선 하는중
    //unit, cityName은 api layer에서 받아야지?

    @Override
    public ApiVariable CreateApiVariable(ApiVariable test) {
        System.out.println(test.getCityId());
//        String cityId = cityRepository.findCityIdByCityName(cityName);
//        apiVariable = new ApiVariable(unit, cityId);

        return apiVariable;
    }

    @Override
    public String getURI() {
        StringBuilder targetURI = new StringBuilder();
        System.out.println(apiVariable.getCityId() + " " + apiVariable.getUnit());
        targetURI.append(apiVariable.getApiUri());
        targetURI.append("id=").append(apiVariable.getCityId());
        targetURI.append("&appid=").append(ApiVariable.getApiKey());
        targetURI.append("&units=").append(apiVariable.getUnit());

        return targetURI.toString();
    }
//

//    public ApiVariable showApi() {
//        return apiVariable;
//    }
}
