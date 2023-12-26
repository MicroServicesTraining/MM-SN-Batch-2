/**
 * 
 */
package com.servicenow.msdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/wish")
public class DemoController {

	@RequestMapping(path = "/goodmorning", method = RequestMethod.GET)
	public String sayGoodMorning() {
		return "Hello User! Good Morning";
	}
	
	//@RequestMapping(path = "/goodevening", method = RequestMethod.GET)
	@GetMapping("/goodevening")
	public String sayGoodEvening() {
		return "Hello User! Good Evening";
	}
	
}
