package com.kay.weather.config;

import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

//https://www.baeldung.com/spring-bean
@Configuration
//@ComponentScan(basePackageClasses = ApiVariable.class)
public class Config {
    @Bean
    @Scope(value = "prototype")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

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
//    @Lazy
//    public Function<Object, Object> factory() {
//        return arg -> apiVariable();
//    }

//    @Bean
//    @Lazy
//    public CityDTO cityDto() {
//        System.out.println("bean iiiiiiii");
//        return new CityDTO();
//    }
//
//    @Bean
//    @Lazy(value = false)
//    public WeatherInfo weatherInfo() {
//        System.out.println("bean weather");
//        return new WeatherInfo();
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
