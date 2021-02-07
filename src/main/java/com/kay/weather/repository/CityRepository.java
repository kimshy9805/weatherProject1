package com.kay.weather.repository;

import com.kay.weather.model.Area;
import com.kay.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {


}
