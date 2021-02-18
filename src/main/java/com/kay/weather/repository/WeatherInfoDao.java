package com.kay.weather.repository;

import com.kay.weather.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WeatherInfoDao {

    //not a di...
    //@Autowired
    private final RestTemplate restTemplate;

    public WeatherInfoDao() {
        restTemplate = new RestTemplate();
    }


    //return WeatherInfo from owm api
    public WeatherInfo getWeatherInfo(String Url) {
        return restTemplate.getForObject(Url, WeatherInfo.class);
    }

}
