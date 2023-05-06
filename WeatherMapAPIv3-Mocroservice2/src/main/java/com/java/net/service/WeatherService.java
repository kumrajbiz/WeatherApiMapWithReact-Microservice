package com.java.net.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.net.entity.Clouds;
import com.java.net.entity.Coord;
import com.java.net.entity.Main;
import com.java.net.entity.Sys;
import com.java.net.entity.Weather;
import com.java.net.entity.WeatherData;
import com.java.net.entity.Wind;

/*
 * Author Rajesh kumar
 * */


@Service
public class WeatherService {
	
	//https://api.openweathermap.org/data/2.5/weather?q=patna&units=metric&appid=d2929e9483efc82c82c32ee7e02d563e
	//https://api.openweathermap.org/data/2.5/forecast?q=patna&appid=d2929e9483efc82c82c32ee7e02d563e&cnt=10
	//private final String URL ="https://api.openweathermap.org/data/2.5/forecast?q=";
	private final String URL ="https://api.openweathermap.org/data/2.5/weather?q=";
	private final String APPID="d2929e9483efc82c82c32ee7e02d563e";

	public WeatherData currentService(String location) {
		WeatherData weatherData = new WeatherData();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
        try {
            URL urlObj = new URL( URL + location + "&appid=" + APPID+"&units=metric");
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                String jsonString = responseBuilder.toString();
                System.out.println("Data string : "+jsonString);
                rootNode = objectMapper.readTree(jsonString);
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

        } catch (Exception e) {
            weatherData = new WeatherData();
            weatherData.setCod(404);
            return weatherData;
        
        }
		return weatherData;
	}
}
