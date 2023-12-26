/**
 * 
 */
package com.servicenow.secdemo.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	/*
	 * @Bean protected InMemoryUserDetailsManager configAuthentication() {
	 * List<UserDetails> users = new ArrayList<>();
	 * 
	 * List<GrantedAuthority> adminAuthority = new ArrayList<GrantedAuthority>();
	 * adminAuthority.add(new SimpleGrantedAuthority("ADMIN")); UserDetails admin =
	 * new User("babu",
	 * "{bcrypt}$2a$10$/kgBopcPjCWAROedQ2i7dO6xmsfjfdC6ecL01JVAOofaSWDdCeiQu",
	 * adminAuthority); users.add(admin);
	 * 
	 * List<GrantedAuthority> studentAuthority = new ArrayList<>();
	 * studentAuthority.add(new SimpleGrantedAuthority("STUDENT")); UserDetails
	 * student = new User("kiran", "{noop}12@bc", studentAuthority);
	 * users.add(student);
	 * 
	 * List<GrantedAuthority> teacherAuthority = new ArrayList<>();
	 * teacherAuthority.add(new SimpleGrantedAuthority("TEACHER")); UserDetails
	 * teacher = new User("ravi", "{noop}4321", teacherAuthority);
	 * users.add(teacher);
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsManager configureAuthentication() {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.setUsersByUsernameQuery("select user_name, user_pwd, enabled from sn_users where user_name = ?");
		userDetailsManager.setAuthoritiesByUsernameQuery("select user_name, role_name from sn_roles where user_name = ?");
		return userDetailsManager;
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
		http
		.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/welcome").permitAll())
		.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/seller/welcome", "/api/seller/menu").hasAnyRole("SELLER", "ADMIN"))
		.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/customer/**").hasAnyRole("CUSTOMER", "ADMIN"))
		.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/admin/**").hasRole("ADMIN"))
		//.formLogin(Customizer.withDefaults());
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
    }
}
