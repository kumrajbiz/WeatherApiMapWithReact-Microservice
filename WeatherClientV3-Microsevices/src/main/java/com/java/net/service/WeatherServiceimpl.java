package com.java.net.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.net.client.WeatherClient;
import com.java.net.entity.Clouds;
import com.java.net.entity.Coord;
import com.java.net.entity.Main;
import com.java.net.entity.Sys;
import com.java.net.entity.Weather;
import com.java.net.entity.WeatherData;
import com.java.net.entity.Wind;

/*
 * Author : Rajesh kumar
 * */


@Service
public class WeatherServiceimpl implements WeatherService {
   
    @Autowired
    private WeatherClient weatherClient;

    
	public WeatherData getWeatherByLocation(String location) {
		
		String response = null;
		String jsonResponse = null;
		JsonNode rootNode = null;
		
		response = weatherClient.getWeatherByLocation(location);
		ObjectMapper objectMapper = new ObjectMapper();

		WeatherData weatherData = new WeatherData();
			try {
				jsonResponse = objectMapper.writeValueAsString(objectMapper.readValue(response, Object.class));
				rootNode = objectMapper.readTree(jsonResponse);
			} catch (Exception e) {
				e.printStackTrace();
			} 
				JsonNode coordNode = rootNode.path("coord");
	            Double lon = coordNode.path("lon").asDouble();
	            Double lat = coordNode.path("lat").asDouble();
	
	            JsonNode weatherArrayNode = rootNode.path("weather");
	            JsonNode weatherNode = weatherArrayNode.get(0);
	            int id = weatherNode.path("id").asInt();
	
	            JsonNode mainNode = rootNode.path("main");
	            double temp = mainNode.path("temp").asDouble();
	            double feelsLike = mainNode.path("feels_like").asDouble();
	            double tempMin = mainNode.path("temp_min").asDouble();
	            double tempMax = mainNode.path("temp_max").asDouble();
	            int pressure = mainNode.path("pressure").asInt();
	            int humidity = mainNode.path("humidity").asInt();
	            String base = mainNode.path("base").asText();
	            		
	            JsonNode windNode = rootNode.path("wind");
	            double windSpeed = windNode.path("speed").asDouble();
	            int windDeg = windNode.path("deg").asInt();
	
	            JsonNode cloudsNode = rootNode.path("clouds");
	            int all = cloudsNode.path("all").asInt();
	
	            JsonNode sysNode = rootNode.path("sys");
	            int type = sysNode.path("type").asInt();
	            int sysId = sysNode.path("id").asInt();
	            String country = sysNode.path("country").asText();
	            long sunrise = sysNode.path("sunrise").asLong();
	            long sunset = sysNode.path("sunset").asLong();
	
	            int timezone = rootNode.path("timezone").asInt();
	            int idmain = rootNode.path("id").asInt();
	            String name = rootNode.path("name").asText();
	            int cod = rootNode.path("cod").asInt();
	
	            weatherData.setCoord(new Coord(lon, lat));
	            List<Weather> weatherList = new ArrayList<>();
	            for (JsonNode weatherInnerNode : weatherArrayNode) {
	                String description = weatherInnerNode.get("description").asText();
	                String icon = weatherInnerNode.get("icon").asText();
	                String main = weatherNode.path("main").asText();
	                Weather weatherInner = new Weather(id, main, description, icon);
	                weatherList.add(weatherInner);
	            }
	            weatherData.setMain(new Main(temp, feelsLike, tempMin, tempMax, pressure, humidity));
	            weatherData.setWind(new Wind(windSpeed, windDeg));
	            weatherData.setClouds(new Clouds(all));
	            weatherData.setSys(new Sys(type, sysId, country, sunrise, sunset));
	            weatherData.setTimezone(timezone);
	            weatherData.setId(id);
	            weatherData.setName(name);
	            weatherData.setCod(cod);
	            weatherData.setBase(base);
	            weatherData.setWeather(weatherList);
			return weatherData;
	}

}
