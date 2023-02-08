package com.works.weatherapi.service;

import com.works.weatherapi.entity.Weather;
import com.works.weatherapi.util.Renum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class WeatherService {


    public ResponseEntity list(Weather weather){




        Map<Renum, Object> hm = new LinkedHashMap<>();
        hm.put(Renum.result,weather);
        hm.put(Renum.status,true);


        return new ResponseEntity<>(hm, HttpStatus.OK);

    }
}
