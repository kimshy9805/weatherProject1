package com.kay.weather.service;

import com.kay.weather.model.ApiVariable;
import com.kay.weather.repository.CityRepository;
import com.kay.weather.utils.JsonToSql;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenWeatherServiceImpl implements OpenWeatherService {

    //Without Di
    private final ApiVariable apiVariable;
    private HashMap<String, String> parsedVariable;

    public OpenWeatherServiceImpl(JSONObject test) throws ParseException {
        parsedVariable = parseApiVariable(test);
        System.out.println(parsedVariable.get("metric"));
        this.apiVariable = new ApiVariable(parsedVariable.get("metric"), parsedVariable.get("cityId"));
    }

    @Override
    public String getURL() {
        StringBuilder targetURI = new StringBuilder();
        System.out.println(apiVariable.getCityId() + " " + apiVariable.getUnit());
        targetURI.append(apiVariable.getApiUri());
        targetURI.append("id=").append(apiVariable.getCityId());
        targetURI.append("&appid=").append(ApiVariable.getApiKey());
        targetURI.append("&units=").append(apiVariable.getUnit());

        return targetURI.toString();
    }

    @Override
    public HashMap<String, String> parseApiVariable(JSONObject test) throws ParseException {
        parsedVariable = new HashMap<>();
//        JSONParser jsonParser = new JSONParser();
//        Object jsonObj = jsonParser.parse(String.valueOf(test));
//        JSONArray cityList = (JSONArray) jsonObj;
//
//        for(Object tt: cityList) {
//            JSONObject ttt = (JSONObject) tt;
        String metric = (String) test.get("metric");
        String cityId = (String) test.get("cityId");
        parsedVariable.put("metric", metric);
        parsedVariable.put("cityId", cityId);
        //}

        return parsedVariable;
    }


}
