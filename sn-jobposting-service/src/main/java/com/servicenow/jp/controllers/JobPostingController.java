/**
 * 
 */
package com.servicenow.jp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping("/jp")
public class JobPostingController {

	@GetMapping("/jobposting")
	public String getJobPosting() {
		return "Job Posting from Job Posting Service";
	}
	
}
