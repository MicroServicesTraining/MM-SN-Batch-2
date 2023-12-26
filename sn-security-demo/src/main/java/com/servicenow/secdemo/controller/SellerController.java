/**
 * 
 */
package com.servicenow.secdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/api/seller")
public class SellerController {

	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		return "Welcome Seller";
	}
	
	@GetMapping("/menu")
	public String showSellerMenu() {
		return "Seller Operations Menu";
	}
}
