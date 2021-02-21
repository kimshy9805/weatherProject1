package com.kay.weather.repository;

import com.kay.weather.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherInfoDao {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherInfo getWeatherInfo(String Url) {
        return restTemplate.getForObject(Url, WeatherInfo.class);
    }

}
