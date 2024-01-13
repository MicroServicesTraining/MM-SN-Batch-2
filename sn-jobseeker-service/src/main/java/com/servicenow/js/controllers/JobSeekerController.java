/**
 * 
 */
package com.servicenow.js.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.servicenow.js.services.JobSeekerService;

/**
 * 
 */
@RestController
@RequestMapping("/js")
public class JobSeekerController {

	
	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping("/jobposting")
	public String getJobPostingInfo() {
		return jobSeekerService.getJobPostingInfo();
	}
	
}
