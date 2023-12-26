/**
 * 
 */
package com.servicenow.propsdemo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.servicenow.propsdemo.config.EcomConfig;
import com.servicenow.propsdemo.model.Product;
import com.servicenow.propsdemo.services.ProductService;

/**
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/*
	 * @Value("${ecom.header}") private String ecomHeader;
	 * 
	 * @Value("${ecom.maxlimit}") private String maxLimit;
	 * 
	 * @Value("${ecom.minlimit}") private String minLimit;
	 */
	
	@Autowired
	private EcomConfig ecomConfig;

	@Override
	public String getHeaderAndLimits() {
		/*return "From Service ::: " + ecomHeader + 
				"Max Limit : "+ maxLimit +
				"Min Limit : "+ minLimit;*/
		return "From Service ::: " + ecomConfig.getHeader() + 
				"Max Limit : "+ ecomConfig.getMaxlimit() +
				"Min Limit : "+ ecomConfig.getMinlimit() +
				"Message :::: " + ecomConfig.getMessage();
				
	}
	

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setId(1001);
		product1.setName("Lenovo Thinkpad 3");
		product1.setPrice(58000.00);
		product1.setMfgr("Lenovo");
		products.add(product1);
		
		Product product2 = new Product();
		product2.setId(1002);
		product2.setName("Dell Vastro");
		product2.setPrice(68000.00);
		product2.setMfgr("Dell");
		products.add(product2);
		
		return products;
	}

}
