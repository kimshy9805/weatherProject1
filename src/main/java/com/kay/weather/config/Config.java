package com.kay.weather.config;

import com.kay.weather.model.City;
import com.kay.weather.model.Country;
import com.kay.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

//https://www.baeldung.com/spring-bean
@Configuration
//여기서 bean먼저 생성하고 그다음에 di 파트로 가서 inject
public class Config implements ApplicationRunner {
    //언제든지 config class에 autowire사용가능.
    @Autowired
    private CityRepository cityRepository;

    @Bean
    @Scope(value = "singleton")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

//    if you use the default scopes of spring beans the creation happens at startup / deployment.
//    Only the injection will happen at runtime.
    @Bean("countryList")
    @Scope(value = "singleton")
    public Country getListOfCountry() {
        List<String> countryList = cityRepository.getCountryList();
        return new Country(countryList);
    }

    //runTime 때 이 getListOfCounrtry 가 실행되서 bean으로 만든듯. 이후에는 빠르게 빠르게 가능.
    //여기서 핋요한 bean을 미리 invoke 시킴.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        getListOfCountry();
        System.out.println("done with runnder");
    }


//
//    @Bean
//    public CommandLineRunner run() throws Exception {
//        return args -> {
//            List<String> countryList = cityRepository.getCountryList();
//        };
//    }




    //Bean type
    //scope:
    //1. singleton:  the container creates a single instance of that bean; all requests for that bean name will return the same object, which is cached
    //2. prototype:  return a different instance every time it is requested from the container

    /*
        Bean has two types: @bean and commandlinerunner
        1. @bean: happens during complie
        2. commandlinrunner: happens during runtime. Right after application context has been loaded and started.
        뭐를 complie때할껀지 runtime때 할껀지 나누는게 중요하다


     */









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
