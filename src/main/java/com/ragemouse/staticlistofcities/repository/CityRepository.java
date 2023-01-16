package com.ragemouse.staticlistofcities.repository;
import com.ragemouse.staticlistofcities.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
