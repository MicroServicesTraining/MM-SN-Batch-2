/**
 * 
 */
package com.servicenow.js.controllers;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicenow.js.services.JobSeekerService;

/**
 * 
 */
@RestController
@RequestMapping("/js")
public class JobSeekerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobSeekerController.class);
	
	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping("/jobposting")
	public String getJobPostingInfo() throws Exception, ExecutionException {
		LOGGER.info("getJobPostingInfo() from JobSeekerController");
		return jobSeekerService.getJobPostingInfo();
	}
	
}
