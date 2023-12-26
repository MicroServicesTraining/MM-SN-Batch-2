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
@RequestMapping("/api/admin")
public class AdminController {

	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		return "Welcome Admin";
	}
	
	@GetMapping("/menu")
	public String showAdminMenu() {
		return "Admin Operations Menu";
	}
	
}
