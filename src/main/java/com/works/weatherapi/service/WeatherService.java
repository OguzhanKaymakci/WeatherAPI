package com.works.weatherapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.works.weatherapi.entity.Weather;
import com.works.weatherapi.util.Renum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherService {


    public ResponseEntity listCurrentWeatherData(String countryCode, String city){

        HashMap<Renum,Object> hm= new LinkedHashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        String weatherURL = "https://api.openweathermap.org/data/2.5/weather?q="+ city+ "&appid=d0e16479472d566f0b85919fb9f7bc5f";
        String weather = restTemplate.getForObject(weatherURL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(weather);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        hm.put(Renum.result,jsonNode);
        hm.put(Renum.status,true);

        System.out.println(jsonNode+"/*************************/");

        return new ResponseEntity<>(hm, HttpStatus.OK);
    }


    //You can search weather forecast for 4 days (96 hours) with data every hour by city name

    public ResponseEntity hourlyForecast4Days(String countryCode,String city){
        HashMap<Renum,Object> hm=new LinkedHashMap();
        hm.put(Renum.status,true);

        RestTemplate restTemplate = new RestTemplate();
        String weatherURL = "https://pro.openweathermap.org/data/2.5/forecast/hourly?q="+ city+","+countryCode+"&appid=d0e16479472d566f0b85919fb9f7bc5f";
        /*String weatherURL = "https://pro.openweathermap.org/data/2.5/forecast/hourly?q=" +city+ "&appid=d0e16479472d566f0b85919fb9f7bc5f";*/
        String weather = restTemplate.getForObject(weatherURL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(weather);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        hm.put(Renum.result,jsonNode);
        hm.put(Renum.status,true);

        System.out.println(jsonNode+"/*************************/");



        return new ResponseEntity(hm,HttpStatus.OK);
    }


    //for 30 days
    public ResponseEntity hourlyForecast30Days(String countryCode,String city){
        HashMap<Renum,Object> hm=new LinkedHashMap();
        hm.put(Renum.status,true);



        RestTemplate restTemplate = new RestTemplate();
        String weatherURL = "https://pro.openweathermap.org/data/2.5/forecast/climate?q="+ city+","+countryCode+"&appid=0a25dff45d134f2a3a919b8a7f75e718";

        String weather = restTemplate.getForObject(weatherURL, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(weather);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        hm.put(Renum.result,jsonNode);
        hm.put(Renum.status,true);

        System.out.println(jsonNode+"/*************************/");



        return new ResponseEntity(hm,HttpStatus.OK);
    }



}
