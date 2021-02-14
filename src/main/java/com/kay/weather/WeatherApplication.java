package com.kay.weather;

import com.kay.weather.config.Config;
import com.kay.weather.model.ApiVariable;
import com.kay.weather.utils.JsonToSql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WeatherApplication.class, args);


		System.out.println("----------------------------------");
//		ApiVariable var = context.getBean(ApiVariable.class);
//		System.out.println(var.getCityId() + " " + var.getUnit());


		//JsonToSql temp = new JsonToSql();
	}



}
