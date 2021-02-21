package com.kay.weather.config;

import com.kay.weather.model.City;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//https://www.baeldung.com/spring-bean
@Configuration
@ComponentScan(value = "com.kay.weather")
public class Config {
    //언제든지 config class에 autowire사용가능.
    @Autowired
    private CityRepository cityRepository;

    @Bean
    @Scope(value = "prototype")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    @Scope(value = "prototype")
//    public List<String> listOfCountry() {
//        return cityRepository.getCountryList() ;
//    }

    //    @Bean
//    @Scope(value = "prototype")
//    @Lazy
//    public ApiVariable apiVariable(String unit, String cityId) {
//        ApiVariable api = new ApiVariable(unit, cityId);
//
//        return api;
//    }

    //@Value 가 bean parameter로 넣어줄수있게 해주는 놈.
//    @Bean(name = "ApiVariable")
//    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//   // @Value("ing")
//    @Lazy
//    // TODO: 15/02/2021 이부분 해결하면됨.
//    //이 빈에서 String을 받아서 무조건 여기서 initialize를 해줘야함. 아니면 노답.
//    public ApiVariable apiVariable() {
//        ApiVariable api = new ApiVariable();
//        System.out.println("bean initiliazeed");
//        return api;
//    }


//    @Bean
//    CommandLineRunner commandLineRunner(CityRepository cityrepository) {
//        return args -> {
//            cityrepository.saveAll(
//                    List.of(serangoon)
//            );
//        };
//    }

}
