package com.servicenow.sdserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SnSdServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnSdServerApplication.class, args);
	}

}
