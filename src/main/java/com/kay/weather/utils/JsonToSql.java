package com.kay.weather.utils;

import com.sun.xml.bind.v2.TODO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/* useful websites for json parse
    https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
    https://www.geeksforgeeks.org/parse-json-java/
 */


//insert into person (first_name, gender, date_of_birth, country_of_birth) values();
public class JsonToSql {
    private static final String FILE_PATH = "/Users/TRECE/desktop/projectCollection/weather/src/main/resources";
    private static HashMap<Object, Object> cityInfoContainer;


    public JsonToSql() {
    }

    public static void readFile() {
        JSONParser jsonParser = new JSONParser();

        //Read Json file
        try (FileReader reader = new FileReader(FILE_PATH + "/example.txt"))
        {
            Object jsonObj = jsonParser.parse(reader);

            JSONArray cityList = (JSONArray) jsonObj;

            //Iterate over city_list array
            cityList.forEach(city -> parseCityObject( (JSONObject) city ) );

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseCityObject(JSONObject city) {
        cityInfoContainer = new HashMap<>();
        //Get cityId
        Long cityId = (Long) city.get("id");
        cityInfoContainer.put("id", cityId);

        //Get cityName
        String cityName = (String) city.get("name");
        cityInfoContainer.put("name", cityName);

        //Get cityState
        String cityState = (String) city.get("state");
        cityInfoContainer.put("state", cityState);

        //Get cityCountry
        String cityCountry = (String) city.get("country");
        cityInfoContainer.put("country", cityCountry);

        //Get coordinate object within list
        JSONObject cityCoordinate = (JSONObject) city.get("coord");
        Double lat = (Double) cityCoordinate.get("lat");
        Double lon = (Double) cityCoordinate.get("lon");
        cityInfoContainer.put("latitude", lat);
        cityInfoContainer.put("longitude", lon);

        createSQLFile(cityInfoContainer);

    }

    //TODO make sql file for insertCommand
    //TODO hashmap optimization
    public static void createSQLFile(HashMap<Object, Object> cityInfoContainer) {
        String insertCommand = "insert into weather_city";;

        cityInfoContainer.forEach((k,v) -> {
           switch ((String) k) {
               case "cityId":
                   break;
               case "cityName":
                   break;
               case "cityState":
                   break;
               case "cityCountry":
                   break;
               case "latitude":
                   break;
               case "longitude":
                   break;
           }
        });

        //make sql file that has insertCommand

    }
}
