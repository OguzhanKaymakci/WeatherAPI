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


    public ResponseEntity list(String country, String city){

        HashMap<Renum,Object> hm= new LinkedHashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        /*String weatherURL = "http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=" + city + "," + country;*/
        //String weatherURL = "https://api.openweathermap.org/data/3.0/onecall?lat="+city+"&lon="+country+"&appid={d0e16479472d566f0b85919fb9f7bc5f}";
        //String weatherURL = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=d0e16479472d566f0b85919fb9f7bc5f";
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


}
