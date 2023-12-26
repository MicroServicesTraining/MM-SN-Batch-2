/**
 * 
 */
package com.servicenow.msdemo.servicre;

import java.util.List;

import com.servicenow.msdemo.entities.Product;

/**
 * 
 */

public interface ProductService {
	
	public List<Product> fetchProductsList();
	public String createProduct(Product product);
	public String modifyProduct(Product product, Long id);
	public String deleteProduct(Long id);
	public Product getProductById(Long id);
	public List<Product> getProductByName(String name);
	public List<Product> getProductsByNameOrPrice(String name, Double price);
	public List<Product> getProductByPrice(Double price);
	public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice);

}
