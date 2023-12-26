/**
 * 
 */
package com.servicenow.msdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.servicenow.msdemo.entities.Product;

/**
 * 
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
	
	//@Query(name = "findByPrice", value = "select p from Product p where p.price > ?1")
	List<Product> getProductByPrice(Double price);
	
	//@Query(name = "findByPriceRange", value = "select p from Product p where p.price > ?1 and p.price < ?2")
	List<Product> getProductsByPriceRange(@Param(value = "minPrice") Double minPrice, @Param(value = "maxPrice") Double maxPrice);

	List<Product> findByNameOrPrice(String name, Double price);
	
	

}
