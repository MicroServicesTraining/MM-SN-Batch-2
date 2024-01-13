/**
 * 
 */
package com.servicenow.js.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * 
 */
@Service
public class JobSeekerService {
	
	@Autowired
	private RestTemplate restTemplate;

	@CircuitBreaker(name = "JobSeeker", fallbackMethod = "getJobPostingInfoFallback")
	public String getJobPostingInfo() {
		String jobPostingInfo = restTemplate.getForObject("http://JOBPOSTINGS/jp/jobposting", String.class);
		return jobPostingInfo;
	}
	
	public String getJobPostingInfoFallback(Exception e) {
		return "Servers have encountered some problem, please try again after some time";
	}

}
