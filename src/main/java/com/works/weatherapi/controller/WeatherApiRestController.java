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

    @PostMapping("/list/Current/Weather/Data")
    public ResponseEntity listCurrentWeatherData(@Valid @RequestParam(value = "countryCode") String countryCode,@Valid
                               @RequestParam(value = "city") String city){
        return weatherService.listCurrentWeatherData(countryCode,city);

    }

    //You can search weather forecast for 4 days (96 hours) with data every hour by city name


    @PostMapping("/list/hourly/Forecast4/Days")
    public ResponseEntity hourlyForecast4Days(@Valid @RequestParam(value = "countryCode") String countryCode,@Valid
    @RequestParam(value = "city") String city){
        return weatherService.hourlyForecast4Days(countryCode,city);

    }

    //hourlyForecast30Days

    @PostMapping("/list/hourly/Forecast30/Days")
    public ResponseEntity hourlyForecast30Days(@Valid @RequestParam(value = "countryCode") String countryCode,@Valid
    @RequestParam(value = "city") String city){
        return weatherService.hourlyForecast30Days(countryCode,city);

    }
}
