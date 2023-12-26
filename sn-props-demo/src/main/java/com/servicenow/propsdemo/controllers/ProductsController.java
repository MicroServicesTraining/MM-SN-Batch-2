/**
 * 
 */
package com.servicenow.propsdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicenow.propsdemo.config.EcomConfig;
import com.servicenow.propsdemo.model.Product;
import com.servicenow.propsdemo.services.ProductService;

/**
 * 
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	/*@Value("${ecom.header}")
	private String ecomHeader;

	@Value("${ecom.maxlimit}")
	private String maxLimit;

	@Value("${ecom.minlimit}")
	private String minLimit;*/

	@Autowired
	private EcomConfig ecomConfig;
	
	@GetMapping("/header")
	public String getEcomHeader(){
		//return ecomHeader + "Max Limit :: " + maxLimit +", Min Limit :: " + minLimit;
		return "From Controller ::: " + ecomConfig.getHeader() + 
				"Max Limit : "+ ecomConfig.getMaxlimit() +
				"Min Limit : "+ ecomConfig.getMinlimit();
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/limits")
	public String getHeaderAndLimits() {
		return productService.getHeaderAndLimits();
	}
	
}
