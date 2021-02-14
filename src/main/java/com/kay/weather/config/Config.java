package com.kay.weather.config;

import com.kay.weather.model.ApiVariable;
import com.kay.weather.model.CityDTO;
import com.kay.weather.model.WeatherInfo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

//https://www.baeldung.com/spring-bean
@Configuration
@ComponentScan(basePackageClasses = ApiVariable.class)
public class Config {
    @Bean
    @Scope(value = "prototype")
    @Lazy
    public ApiVariable apiVariable(ApiVariable test) {
        System.out.println("bean 1111 intiailziedddd");
        return new ApiVariable(test);
    }
//
//    @Bean(name = "ApiVariable")
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    @Lazy
//    public ApiVariable apiVariable(String ans1, String ans2) {
//        System.out.println("bean initiliazeed");
//        return new ApiVariable(ans1, ans2);
//    }

    @Bean
    @Lazy(value = false)
    public CityDTO cityDto() {
        return new CityDTO();
    }

    @Bean
    @Lazy(value = false)
    public WeatherInfo weatherInfo() {
        return new WeatherInfo();
    }


//    @Bean
//    CommandLineRunner commandLineRunner(CityRepository cityrepository) {
//        return args -> {
//            cityrepository.saveAll(
//                    List.of(serangoon)
//            );
//        };
//    }

}
