package com.kay.weather.repository;

import com.kay.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
    이 repository는 City db만을 신경을씀
    그리고 최소한 간결해야함.
 */
//Repository -> service에서 요청한걸 db에서 직접적으로 access해서 return
//실제 SQL command를 할필요는 없음. JPArepository가 알아서해줌.
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    // TODO: 11/02/2021  custom query 작성법 + 왜 db가 multiple 값을 return?
    //Query방법은 맞지만 Collection<>이 return type을 고려햐지 못했엇음.
    //ex) List<City> List<Object> 이런걸로
    //@Query("SELECT u FROM User u WHERE u.status = 1")
    //@Query("SELECT DISTINCT s FROM weather_city s WHERE s.city_name = ?1")
    //value = "SELECT DISTINCT u FROM City u WHERE u.city_name = ?1",

    @Query(
            value = "SELECT DISTINCT t.country FROM weather_city t",
            nativeQuery = true
    )
    List<String> getCountryList();

    @Query(
            value = "SELECT DISTINCT city_id FROM weather_city WHERE city_name = ?1",
            nativeQuery = true
    )
    String findCityIdByCityName(String cityName);

    @Query(
            value = "SELECT DISTINCT t.* FROM weather_city t WHERE t.country = ?1",
            nativeQuery = true
    )
    List<City> getCityInfoByCountry(String country);

    @Query(
            value = "SELECT DISTINCT t.city_name FROM weather_city t WHERE t.country = ?1",
            nativeQuery = true
    )
    List<String> getCityListByCountry(String country);

}
