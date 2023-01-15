package com.ragemouse.staticlistofcities.controller;

import com.ragemouse.staticlistofcities.entity.City;
import com.ragemouse.staticlistofcities.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;
    @QueryMapping
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
    @MutationMapping
    @PostMapping
    public City createNewCity(@RequestBody @Argument City city) {
        return cityService.createCity(city);
    }

}
