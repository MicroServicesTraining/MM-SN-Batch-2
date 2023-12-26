/**
 * 
 */
package com.servicenow.msdemo.servicre.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicenow.msdemo.entities.Product;
import com.servicenow.msdemo.repositories.ProductRepository;
import com.servicenow.msdemo.servicre.ProductService;

/**
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> fetchProductsList() {
		return productRepository.findAll();
	}

	@Override
	public String createProduct(Product product) {
		productRepository.save(product);
		return "Product Added Successfully";
	}

	@Override
	public String modifyProduct(Product product, Long id) {
		return "Product Modified";
	}

	@Override
	public String deleteProduct(Long id) {
		return "Product Deleted";
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> result =  productRepository.findById(id);
		return result.orElse(new Product());
		/*
		 * if(result.isPresent()) { return result.get(); } else { return new Product();
		 * }
		 */
	}

	@Override
	public List<Product> getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> getProductsByNameOrPrice(String name, Double price) {
		return productRepository.findByNameOrPrice(name, price);
	}

	@Override
	public List<Product> getProductByPrice(Double price) {
		return productRepository.getProductByPrice(price);
	}

	@Override
	public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
		return productRepository.getProductsByPriceRange(minPrice, maxPrice);
	}

	
}
