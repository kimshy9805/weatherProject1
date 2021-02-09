package com.kay.weather.repository;

import com.kay.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Repository -> service에서 요청한걸 db에서 직접적으로 access해서 return
//실제 SQL command를 할필요는 없음. JPArepository가 알아서해줌.
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT s FROM City s WHERE s.city_name = ?1")
    Optional<City> findCityByCityId(String cityName);

}
