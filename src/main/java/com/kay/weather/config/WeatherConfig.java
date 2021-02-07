package com.kay.weather.config;

import com.kay.weather.model.City;
import com.kay.weather.repository.CityRepository;
import com.kay.weather.utils.JsonToSql;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WeatherConfig {

    @Bean
    CommandLineRunner commandLineRunner(CityRepository cityrepository) {
        return args -> {

            City serangoon = new City(
                    50,
                    "Serangoon",
                    "",
                    "Singapore",
                    1.5,
                    22.2
            );
            cityrepository.saveAll(
                    List.of(serangoon)
            );
        };
    }

}
