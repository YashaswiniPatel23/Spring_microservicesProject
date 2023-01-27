package com.boot.ms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bank {
	@Id
	@Column(name = "bank_id")
	private int id;
	@Column(name = "bank_name")
	private String name;
	@Column(name="bank_city")
	private String city;

}
