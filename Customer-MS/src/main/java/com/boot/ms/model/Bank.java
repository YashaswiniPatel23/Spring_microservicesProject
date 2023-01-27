package com.boot.ms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bank {
	
	private int id;
	private String name;
	private String city;

}
