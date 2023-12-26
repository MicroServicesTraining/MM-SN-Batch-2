/**
 * 
 */
package com.servicenow.propsdemo.model;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
//import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;
import lombok.ToString;

/**
 * 
 */
//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
	private Integer id;
	private String name;
	private Double price;
	private String mfgr;
}
