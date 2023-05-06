package com.java.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.net.entity.WeatherData;
import com.java.net.service.WeatherServiceimpl;

/*
 * Author : Rajesh kumar
 * */


@RestController
@RequestMapping
//for allowing react service to allow access
@CrossOrigin(origins = "http://localhost:9999/")
public class WeatherController {

   
    @Autowired
    private WeatherServiceimpl weatherService;

    @GetMapping("/weather/{location}")
    public ResponseEntity<WeatherData> getWeatherByLocation(@PathVariable("location") String location) {
    	WeatherData weather = null;
    	try {
    		weather = weatherService.getWeatherByLocation(location);
    		return ResponseEntity.ok(weather);
        } catch (Exception e) {
        	weather = new WeatherData();
        	weather.setCod(404);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(weather);
        }
      }
	}