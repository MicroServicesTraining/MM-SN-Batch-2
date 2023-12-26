/**
 * 
 */
package com.servicenow.propsdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * 
 */
@Data
@PropertySource("classpath:ecom.properties")
@ConfigurationProperties(prefix = "ecom")
@Configuration
public class EcomConfig {
	
	//@Value("${ecom.header}")
	private String header;

	//@Value("${ecom.maxlimit}")
	private String maxlimit;

	//@Value("${ecom.minlimit}")
	private String minlimit;
	
	@Value("${message:dummy message}")
	private String message;

}
