/**
 * 
 */
package com.servicenow.msdemo.entities;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "product")
@NamedNativeQueries({
	@NamedNativeQuery(name = "Product.getProductByPrice", query = "select * from product where rate > ?1", resultClass = Product.class)
})
@NamedQueries({
	//@NamedQuery(name = "Product.getProductByPrice", query = "select p from Product p where p.price > ?1"),
	@NamedQuery(name = "Product.getProductsByPriceRange", query = "select p from Product p where p.price > :minPrice and p.price < :maxPrice")
})
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5471479194931298395L;
	
	@Id
	private Long id;
	
	private String name;
	
	@Column(name = "rate")
	private Double price;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "barcode_id", referencedColumnName = "id")
	private Barcode barcode;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Set<Feature> features;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "order_products",
			joinColumns = @JoinColumn(
						name = "product_id", referencedColumnName = "id"
					),
			inverseJoinColumns = @JoinColumn(
						name = "order_id", referencedColumnName = "id"
					)
	)
	private Set<Order> orders;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the features
	 */
	public Set<Feature> getFeatures() {
		return features;
	}
	/**
	 * @param features the features to set
	 */
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}
	/**
	 * @return the barcode
	 */
	public Barcode getBarcode() {
		return barcode;
	}
	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(Barcode barcode) {
		this.barcode = barcode;
	}
	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
