/**
 * 
 */
package com.servicenow.propsdemo.services;

import java.util.List;

import com.servicenow.propsdemo.model.Product;

/**
 * 
 */
public interface ProductService {

	List<Product> getAllProducts();

	String getHeaderAndLimits();
	
}
