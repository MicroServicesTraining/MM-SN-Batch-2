/**
 * 
 */
package com.servicenow.msdemo.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "features")
public class Feature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3052127479427471223L;
	
	@Id
	@Column(name = "feature_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String description;
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
