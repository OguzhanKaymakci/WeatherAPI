package com.works.weatherapi.controller;


import com.works.weatherapi.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/weahter/api")

public class WeatherApiRestController {

    final WeatherService weatherService;

    public WeatherApiRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/list")
    public ResponseEntity list(@Valid @RequestParam(value = "country") String country,@Valid
                               @RequestParam(value = "city") String city){
        return weatherService.list(country,city);

    }
}
