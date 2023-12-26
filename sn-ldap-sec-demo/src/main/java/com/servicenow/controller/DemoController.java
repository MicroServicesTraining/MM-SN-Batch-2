/**
 * 
 */
package com.servicenow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class DemoController {

	@GetMapping("/welcome")
	public String showWelcome() {
		return "Welcome User";
	}
}
