package com.java.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 * Author : Rajesh kumar
 * */

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class WeatherClientMicrosevicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherClientMicrosevicesApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate resttemplet() {
		return new RestTemplate();
	}
}
