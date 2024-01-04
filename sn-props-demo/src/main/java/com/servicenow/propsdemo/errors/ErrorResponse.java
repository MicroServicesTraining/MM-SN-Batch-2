/**
 * 
 */
package com.servicenow.propsdemo.errors;

import lombok.Data;

/**
 * 
 */

@Data
public class ErrorResponse {

	private Integer statusCode;
	private String message;
	
	public ErrorResponse(Integer statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
}
