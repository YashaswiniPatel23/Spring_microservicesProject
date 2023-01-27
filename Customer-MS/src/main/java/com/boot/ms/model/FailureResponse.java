package com.boot.ms.model;

import java.util.List;

import com.boot.ms.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailureResponse {

	private List<Customer> customer;
	private String message;

}
