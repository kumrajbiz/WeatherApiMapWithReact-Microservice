package com.java.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.net.entity.WeatherData;
import com.java.net.service.WeatherService;

/*
 * Author Rajesh kumar
 * */

@CrossOrigin
@RestController
@RequestMapping
public class WeatherController {
	
	@Autowired
	private WeatherService  weatherService;

    @RequestMapping("/weather/{location}")
    public ResponseEntity<WeatherData> current(@PathVariable String location) {
    	 WeatherData weatherData = null;
    	try {
            weatherData = weatherService.currentService(location);
		System.out.println("Data from Weather API "+weatherData.toString());
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(weatherData);
        }
    }
}
