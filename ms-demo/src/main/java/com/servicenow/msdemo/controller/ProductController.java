/**
 * 
 */
package com.servicenow.msdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicenow.msdemo.entities.Product;
import com.servicenow.msdemo.servicre.ProductService;

/**
 * 
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//@RequestMapping(path = "/list", method = RequestMethod.GET)
	@GetMapping
	public List<Product> getProducts() {
		return productService.fetchProductsList();
	}
	
	@GetMapping("/id/{id}")
	public Product getProductById(@PathVariable(name = "id") Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/price/{price}")
	public List<Product> getProductByPrice(@PathVariable Double price) {
		return productService.getProductByPrice(price);
	}
	
	@GetMapping("/pricerange/minPrice/{minPrice}/maxPrice/{maxPrice}")
	public List<Product> getProductsByPriceRange(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
		return productService.getProductsByPriceRange(minPrice, maxPrice);
	}
	
	@GetMapping("/name/{name}")
	public List<Product> getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	@GetMapping("/name/{name}/price/{price}")
	public List<Product> getProductsByNameOrPrice(@PathVariable String name, @PathVariable Double price) {
		return productService.getProductsByNameOrPrice(name, price);
	}
	
	
	
	//@RequestMapping(path = "/new", method = RequestMethod.POST)
	@PostMapping
	public String createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	//@DeleteMapping("/remove")
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		return productService.deleteProduct(id);
	}
	
	//@PutMapping("/modify")
	@PutMapping("/{id}")
	public String modifyProduct(@RequestBody Product product, @PathVariable Long id) {
		return productService.modifyProduct(product, id);
	}
	
}
