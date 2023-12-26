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
@RequestMapping("/api")
public class LmsController {
	
	@GetMapping("/welcome")
	public String lmsWelcome() {
		return "Welcome to LMS";
	}
	
	/*
	 * @GetMapping("/admin") public String getAdminLink() { return "Welcome Admin";
	 * }
	 * 
	 * @GetMapping("/customer") public String getCustomerLink() { return
	 * "Welcome Customer"; }
	 * 
	 * @GetMapping("/seller") public String getSellerLink() { return
	 * "Welcome Seller"; }
	 */
}
