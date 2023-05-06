package com.java.net.service;

import com.java.net.entity.WeatherData;

/*
 * Author : Rajesh kumar
 * */


public interface WeatherService {

	public WeatherData getWeatherByLocation(String location);
}
