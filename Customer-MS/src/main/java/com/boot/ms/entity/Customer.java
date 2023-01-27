package com.boot.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@Column(name = "cid")
	private int id;
	@Column(name = "customer_name")
	private String name;
	@Column(name = "city")
	private String city;
	@Column(name ="bank_id")
	private int bank_id;
	public Customer( String name, String city, int bank_id) {
		super();
		
		this.name = name;
		this.city = city;
		this.bank_id = bank_id;
	}

	

}
