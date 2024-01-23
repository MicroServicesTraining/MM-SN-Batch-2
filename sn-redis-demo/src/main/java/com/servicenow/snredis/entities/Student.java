/**
 * 
 */
package com.servicenow.snredis.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * 
 */
@Data
@Entity
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2806899696867723685L;

	@Id
	@Column(name = "roll_no")
	private Long rollNo;
	
	private String name;
	private Double fee;

}
