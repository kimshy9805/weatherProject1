package com.kay.weather.service;

import com.kay.weather.model.OpenWeatherMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public class OpenWeatherServiceImpl implements OpenWeatherService {

    //Without Di
    private final OpenWeatherMap OWM;
    private HashMap<String, String> parsedVariable;

    public OpenWeatherServiceImpl(JSONObject test) throws ParseException {
        parsedVariable = parseApiVariable(test);
        this.OWM = new OpenWeatherMap(parsedVariable.get("metric"), parsedVariable.get("cityId"));
    }

    @Override
    public String getURL() {
        StringBuilder targetURL = new StringBuilder();
        targetURL.append(OWM.getApiUri());
        targetURL.append("id=").append(OWM.getCityId());
        targetURL.append("&appid=").append(OWM.getApiKey());
        targetURL.append("&units=").append(OWM.getUnit());

        return targetURL.toString();
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
