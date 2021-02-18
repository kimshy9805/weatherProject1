package com.kay.weather.service;

import com.kay.weather.model.OpenWeatherMap;
import com.kay.weather.model.WeatherInfo;
import com.kay.weather.repository.CityRepository;
import com.kay.weather.repository.WeatherInfoDao;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OpenWeatherServiceImpl implements OpenWeatherService {
    private List<WeatherInfo> dataArr;
    private OpenWeatherMap OWM;
    private HashMap<String, String> parsedVariable;
    private WeatherInfoDao weatherInfoDao;
    @Autowired
    private CityRepository cityRepository;
//    @Autowired
//    private WeatherInfoDao weatherInfoDao;

    public OpenWeatherServiceImpl() {
        this.OWM = new OpenWeatherMap();
    }


    //OWM model이 에매함;
    @Override
    public String getURL(String cityId) {
        return OpenWeatherMap.getUrlApi() +
                "id=" + cityId +
                "&appid=" + OpenWeatherMap.getApiKey() +
                "&units=metric";
    }

    @Override
    public List<WeatherInfo> getWeatherInfo(String cityName) {
        //1. get cityId
        String cityId = cityRepository.findCityIdByCityName(cityName);
        System.out.println(cityId);

        //2. get url
        String Url = getURL(cityId);
        System.out.println("url is" + Url);

        //object
        weatherInfoDao = new WeatherInfoDao();
        WeatherInfo weatherInfo = weatherInfoDao.getWeatherInfo(Url);
        System.out.println(weatherInfo.toString());

        //3. return weatherinfo list
        dataArr = new ArrayList<>();
        dataArr.add(weatherInfo);
        return dataArr;
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
