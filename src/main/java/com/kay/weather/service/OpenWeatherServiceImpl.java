package com.kay.weather.service;

import com.kay.weather.model.OpenWeatherMap;
import com.kay.weather.model.WeatherInfo;
import com.kay.weather.repository.CityRepository;
import com.kay.weather.repository.WeatherInfoDao;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {
    private HashMap<String, String> parsedVariable;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private WeatherInfoDao weatherInfoDao;


    //여기서 db access랑 rest template 한번에 두개 이용해서 시간이 오래걸림.
    @Override
    public List<WeatherInfo> getWeatherInfo(String cityName) {
        List<WeatherInfo> weatherInfoList = new ArrayList<>();
        String cityId;
        String Url;

        //1. get cityId
        cityId = cityRepository.findCityIdByCityName(cityName);

        //2. get url
        Url = getURL(cityId);

        //3. get object
        WeatherInfo weatherInfo = weatherInfoDao.getWeatherInfo(Url);

        //3. return weatherinfo list
        weatherInfoList.add(weatherInfo);
        return weatherInfoList;
    }

    @Override
    public String getURL(String cityId) {
        return OpenWeatherMap.getUrlApi() +
                "id=" + cityId +
                "&appid=" + OpenWeatherMap.getApiKey() +
                "&units=metric";
    }


    @Override
    public HashMap<String, String> parseApiVariable(JSONObject test) throws ParseException {
        parsedVariable = new HashMap<>();
        String metric = (String) test.get("metric");
        String cityId = (String) test.get("cityId");
        parsedVariable.put("metric", metric);
        parsedVariable.put("cityId", cityId);

        return parsedVariable;
    }
}
