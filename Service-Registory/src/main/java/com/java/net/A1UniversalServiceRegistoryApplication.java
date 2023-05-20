package com.java.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * Author : Rajesh kumar
 * */

@EnableEurekaServer
@SpringBootApplication
public class A1UniversalServiceRegistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(A1UniversalServiceRegistoryApplication.class, args);
	}

}
