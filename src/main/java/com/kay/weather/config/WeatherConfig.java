package com.kay.weather.config;

import com.kay.weather.model.City;
import com.kay.weather.repository.CityRepository;
import com.kay.weather.utils.JsonToSql;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//https://www.baeldung.com/spring-bean
@Configuration
public class WeatherConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(CityRepository cityrepository) {
//        return args -> {
//            cityrepository.saveAll(
//                    List.of(serangoon)
//            );
//        };
//    }

}
