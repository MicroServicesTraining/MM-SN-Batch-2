/**
 * 
 */
package com.mm.jwt.service;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims; 

@Component
public interface JwtService { 

	public String generateToken(String userName) ;

	public String extractUsername(String token);

	public Date extractExpiration(String token);

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	public Boolean validateToken(String token, UserDetails userDetails);


} 

