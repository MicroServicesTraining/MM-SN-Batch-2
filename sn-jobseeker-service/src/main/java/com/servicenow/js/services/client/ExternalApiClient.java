/**
 * 
 */
package com.servicenow.js.services.client;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 
 */
@Component
public class ExternalApiClient {
	
	@Autowired
	private RestTemplate restTemplate;

	@Async
	public CompletableFuture<String> callJobPostingInfoApi() {
		String jobPostingInfo = restTemplate.getForObject("http://JOBPOSTINGS/jp/jobposting", String.class);
		return CompletableFuture.completedFuture(jobPostingInfo);
	}
	
	@Async
	public CompletableFuture<String> callJobCompanyInfoApi() {
		String jobPostingCompany = restTemplate.getForObject("http://JOBPOSTINGS/jp/jobcompany", String.class);
		return CompletableFuture.completedFuture(jobPostingCompany);
	}
	
}
