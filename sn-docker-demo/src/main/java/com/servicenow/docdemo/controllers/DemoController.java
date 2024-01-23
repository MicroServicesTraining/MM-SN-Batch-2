/**
 * 
 */
package com.servicenow.docdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
public class DemoController {

	@GetMapping("/sayhello")
	public String sayHello() {
		return "Hello User...!";
	}
}
