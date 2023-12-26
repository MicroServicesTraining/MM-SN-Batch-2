/**
 * 
 */
package com.servicenow.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.PostConstruct;

/**
 * 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	AuthenticationManagerBuilder auth;
	
	@PostConstruct
	public void configAuthentication() throws Exception {
		auth.ldapAuthentication()
		.userDnPatterns("uid={0},ou=people")
		.groupSearchBase("ou=groups")
		.contextSource()
		.url("ldap://localhost:8090/dc=springframework,dc=org")
		.and()
		.passwordCompare()
		.passwordEncoder(new LdapShaPasswordEncoder())
		.passwordAttribute("userPassword");
	}

	
	@Bean
	public SecurityFilterChain configAuthorizations(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/welcome").fullyAuthenticated())
				.formLogin(Customizer.withDefaults())
				.build();
	}
	
}
