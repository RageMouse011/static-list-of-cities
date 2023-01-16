package com.ragemouse.staticlistofcities.controller;

import com.ragemouse.staticlistofcities.entity.City;
import com.ragemouse.staticlistofcities.service.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
@Slf4j
public class CityController {
    private final CityService cityService;
    @QueryMapping
    @GetMapping
    @MessageMapping("/cities")
    @SendTo("/topic/clientCities")
    @SubscribeMapping("/topic/cities")
    public List<City> getAllCities() throws ExecutionException, InterruptedException {
        log.info("Controller");
        return cityService.getAllCities();
    }
    @MutationMapping
    @PostMapping
    public City createNewCity(@RequestBody @Argument City city) throws ExecutionException, InterruptedException {
        return cityService.createCity(city);
    }

}
