package com.servicenow.msdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "com.servicenow.ms.controller")
@SpringBootApplication
public class MsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDemoApplication.class, args);
	}

}
