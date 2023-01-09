package com.ragemouse.staticlistofcities.service;

import com.ragemouse.staticlistofcities.entity.City;
import com.ragemouse.staticlistofcities.repository.CityRepository;
import com.ragemouse.staticlistofcities.util.EventClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CitiesService {

    private final CityRepository cityRepository;

    public List<City> getAllCitiesFromWebSocket(){
        List<City> findAllCities = cityRepository.findAll();
        String allCities = findAllCities.toString();
        EventClient.createEventClient(allCities);
        return findAllCities;
    }

    public List<City> getAllCitiesWithRepository(){
        return getAllCitiesFromWebSocket();
    }

    public City createCity(City city){
        city = cityRepository.save(city);
        getAllCitiesFromWebSocket();
        return city;
    }
}
