/**
 * 
 */
package com.mm.jwt.filter;

import jakarta.servlet.FilterChain; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.security.core.context.SecurityContextHolder; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource; 
import org.springframework.stereotype.Component; 
import org.springframework.web.filter.OncePerRequestFilter;

import com.mm.jwt.service.JwtService;
import com.mm.jwt.service.impl.UserInfoService;

import java.io.IOException; 

// This class helps us to validate the generated jwt token 
@Component
public class JwtAuthFilter extends OncePerRequestFilter { 

	@Autowired
	private JwtService jwtService; 

	@Autowired
	private UserInfoService userDetailsService; 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
		String authHeader = request.getHeader("Authorization"); 
		String token = null; 
		String username = null; 
		//authHeader = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYWJ1IiwiaWF0IjoxNzA0MzM4NzY0LCJleHAiOjE3MDQzNDA1NjR9.MrCUK677PKUfApXaafLqgc4ePTu-y9Uw_22_KzizEPU";
		if (authHeader != null && authHeader.startsWith("Bearer ")) { 
			token = authHeader.substring(7); 
			username = jwtService.extractUsername(token); 
		} 

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { 
			UserDetails userDetails = userDetailsService.loadUserByUsername(username); 
			if (jwtService.validateToken(token, userDetails)) { 
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
				SecurityContextHolder.getContext().setAuthentication(authToken); 
			} 
		} 
		filterChain.doFilter(request, response); 
	} 
} 

