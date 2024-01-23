/**
 * 
 */
package com.servicenow.js.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicenow.js.services.client.ExternalApiClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 * 
 */
@Service
public class JobSeekerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobSeekerService.class);
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ExternalApiClient externalApiClient;

	@CircuitBreaker(name = "JobSeeker", fallbackMethod = "getJobPostingInfoFallback")
	public String getJobPostingInfo() throws Exception, ExecutionException {
		LOGGER.info("getJobPostingInfo() from JobSeekerService");
		//String jobPostingInfo = restTemplate.getForObject("http://JOBPOSTINGS/jp/jobposting", String.class);
		//String jobPostingCompany = restTemplate.getForObject("http://JOBPOSTINGS/jp/jobcompany", String.class);
		//return List.of(jobPostingInfo, jobPostingCompany).toString();
		
		CompletableFuture<String> jobPostingInfo = externalApiClient.callJobPostingInfoApi();
		CompletableFuture<String> jobPostingCompany = externalApiClient.callJobCompanyInfoApi();
		
		return List.of(jobPostingInfo.get(), jobPostingCompany.get()).toString();
	}
	
	public String getJobPostingInfoFallback(Exception e){
		LOGGER.info("getJobPostingInfoFallback() from JobSeekerService");
		return "Servers have encountered some problem, please try again after some time";
	}

}
