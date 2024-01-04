/**
 * 
 */
package com.servicenow.propsdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicenow.propsdemo.config.EcomConfig;
import com.servicenow.propsdemo.model.Product;
import com.servicenow.propsdemo.services.ProductService;

import lombok.extern.log4j.Log4j2;


/**
 * 
 */
@Log4j2
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

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
		/*
		 * LOGGER.trace("Header endpoint - trace log");
		 * LOGGER.debug("Header endpoint - debug log");
		 * LOGGER.info("Header endpoint - info log");
		 * LOGGER.warn("Header endpoint - warn log");
		 * LOGGER.error("Header endpoint - error log");
		 */
		
		log.trace("Header endpoint - trace log");
		log.debug("Header endpoint - debug log");
		log.info("Header endpoint - info log");
		log.warn("Header endpoint - warn log");
		log.error("Header endpoint - error log");
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
	
	
	@GetMapping("/calcdiscount/price/{price}/percent/{percent}")
	public ResponseEntity<Object> calculatedDiscount(@PathVariable String price, @PathVariable String percent) {
		double priceValue = Double.valueOf(price);
		int percentValue = Integer.valueOf(percent);	
		double discount = (priceValue * percentValue ) / 100;
		return new ResponseEntity<Object>("Discount ::: " + discount, HttpStatus.OK);	
	}
	
	
}
