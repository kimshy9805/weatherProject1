package com.kay.weather;

import com.kay.weather.config.Config;
//import com.kay.weather.model.Country;
import com.kay.weather.utils.JsonToSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kay.weather")
public class WeatherApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeatherApplication.class, args);



		System.out.println("----------------------------------");


	}



}
