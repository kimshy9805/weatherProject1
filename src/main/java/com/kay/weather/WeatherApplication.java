package com.kay.weather;

import com.kay.weather.utils.JsonToSql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);


		System.out.println("----------------------------------");
		//JsonToSql temp = new JsonToSql();
	}



}
