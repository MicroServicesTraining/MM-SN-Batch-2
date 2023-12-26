/**
 * 
 */
package com.servicenow.secdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		return "Welcome Customer";
	}
	
	@GetMapping("/menu")
	@PreAuthorize("hasRole('CUSTOMER')")
	public String showCustomerMenu() {
		return "Customer Operations Menu";
	}
	
}
