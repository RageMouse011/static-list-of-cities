package com.ragemouse.staticlistofcities.service;

import com.ragemouse.staticlistofcities.entity.City;
import com.ragemouse.staticlistofcities.repository.CityRepository;
import com.ragemouse.staticlistofcities.util.EventClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;


    public List<City> getAllCitiesFromWebSocket() throws ExecutionException, InterruptedException {
        List<City> findAllCities = cityRepository.findAll();
        String allCities = findAllCities.toString();
        EventClient.createEventClient(allCities);
        return findAllCities;
    }

    public List<City> getAllCities() throws ExecutionException, InterruptedException {
        return getAllCitiesFromWebSocket();
    }

    public City createCity(City city) throws ExecutionException, InterruptedException {
        city = cityRepository.save(city);
        getAllCitiesFromWebSocket();
        return city;
    }
}
