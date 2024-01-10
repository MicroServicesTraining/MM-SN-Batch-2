package com.servicenow.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SnCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnCloudConfigServerApplication.class, args);
	}

}
