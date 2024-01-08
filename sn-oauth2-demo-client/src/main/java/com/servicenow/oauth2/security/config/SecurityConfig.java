/**
 * 
 */
package com.servicenow.oauth2.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(authorize -> {
					authorize.requestMatchers("/welcome").permitAll();
					authorize.anyRequest().authenticated();		
		})
		.oauth2Login(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		
		return http.build();
	}

}
