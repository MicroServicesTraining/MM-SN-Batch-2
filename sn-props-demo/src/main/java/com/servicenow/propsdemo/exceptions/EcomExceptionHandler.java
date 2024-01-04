/**
 * 
 */
package com.servicenow.propsdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.servicenow.propsdemo.errors.ErrorResponse;

/**
 * 
 */
@ControllerAdvice
public class EcomExceptionHandler {

	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		return new ResponseEntity<Object>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),HttpStatus.BAD_REQUEST);
	}	
	
}
