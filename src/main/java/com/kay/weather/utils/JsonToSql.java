package com.kay.weather.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;

/* useful websites for json parse
    https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
    https://www.geeksforgeeks.org/parse-json-java/
 */


public class JsonToSql {
    private static final String FILE_PATH = "/Users/TRECE/desktop/projectCollection/weather/src/main/resources";
    private static HashMap<Object, Object> cityInfoContainer;
    private final File SQL_FILE = new File(FILE_PATH + "/data-mylocal.sql");

    public JsonToSql() {
        createSqlFile();
    }

    //create sql file first
    private void createSqlFile() {
        try {
            if (SQL_FILE.createNewFile()) {
                System.out.println("File created: " + SQL_FILE.getName());
                readFile();
            }
            System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    // TODO: 08/02/2021 write 도중 class java.lang.Double cannot be cast to class java.lang.Long
    // TODO: 08/02/2021 에러가 떠서 solve를 해야함 + 살짝 스파게티 느낌이 나서 solve하고 클래스 다듬어야함.
    public static void readFile() {
        JSONParser jsonParser = new JSONParser();

        //Read Json file
        try (FileReader reader = new FileReader(FILE_PATH + "/example.txt")) {
            Object jsonObj = jsonParser.parse(reader);

            JSONArray cityList = (JSONArray) jsonObj;

            //Iterate over city_list array
            //cityList.forEach(city -> parseCityObject((JSONObject) city));
            try {
                FileWriter myWriter = new FileWriter(FILE_PATH + "/city.sql");

                for (Object city : cityList) {
                    myWriter.write(String.valueOf(parseCityObject((JSONObject) city)));
                    myWriter.write(System.getProperty( "line.separator" ));
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder parseCityObject(JSONObject city) {
        cityInfoContainer = new HashMap<>();
        //Get cityId
        Object cityId = city.get("id");
        cityInfoContainer.put("city_id", cityId);

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
        Object lat = cityCoordinate.get("lat");
        Object lon = cityCoordinate.get("lon");
        cityInfoContainer.put("lat", lat);
        cityInfoContainer.put("lon", lon);

        return makeCommandLine(cityInfoContainer);

    }

    public static StringBuilder makeCommandLine(HashMap<Object, Object> cityInfoContainer) {
        StringBuilder insertCommand = new StringBuilder("insert into weather_city (latitude, longtitude, city_id, city_name, country, state) values(");

        for (int i = 0; i < cityInfoContainer.size(); i++) {
            switch (i) {
                case 0:
                    insertCommand.append(cityInfoContainer.get("lat") + ", ");
                    break;
                case 1:
                    insertCommand.append(cityInfoContainer.get("lon") + ", ");
                    break;
                case 2:
                    insertCommand.append(cityInfoContainer.get("city_id") + ", ");
                    break;
                case 3:
                    insertCommand.append("'" + cityInfoContainer.get("name") + "', ");
                    break;
                case 4:
                    insertCommand.append("'" + cityInfoContainer.get("country") + "', ");
                    break;
                case 5:
                    insertCommand.append("'" + cityInfoContainer.get("state") + "')");
                    break;
            }
        }
        return insertCommand;
    }

//    public static void writeToSqlFile(StringBuilder insertCommand) {
//        try {
//            FileWriter myWriter = new FileWriter(FILE_PATH + "/city.sql");
//            myWriter.write(String.valueOf(insertCommand));
//            myWriter.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }

}
