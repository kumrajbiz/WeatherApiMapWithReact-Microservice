package com.java.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Author Rajesh kumar
 * */

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication

public class WeatherMapApIv3MocroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherMapApIv3MocroserviceApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.java.net.controller"))
	            .build();
	}

}
