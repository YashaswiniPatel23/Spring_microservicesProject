package com.boot.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.boot.ms.entity.Customer;
import com.boot.ms.model.Bank;
import com.boot.ms.model.CustomerBankResponse;
import com.boot.ms.model.FailureResponse;
import com.boot.ms.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/customer")

public class CustomerController {
	@Autowired
	CustomerService service;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getall")
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<List<Customer>>(service.getCustomers(), HttpStatus.OK);

	}

	@GetMapping("getcustomer/{cid}")
	public ResponseEntity<?> getEmployee(@PathVariable int cid) {
		Customer customer = service.getCustomer(cid);
		ResponseEntity<?> responseEntity = null;

		if (customer == null) {
			responseEntity = new ResponseEntity<String>("No customer present with given id  : " + cid,
					HttpStatus.NOT_FOUND);

		} else {
			responseEntity = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		return responseEntity;
	}

	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int cid) {
		service.deleteCustomerById(cid);
		return new ResponseEntity<String>("Deleted Succesfully", HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.addCustomer(customer), HttpStatus.OK);
	}

	@PutMapping("/update")

	public ResponseEntity<Customer> updatedCustomers(@RequestBody Customer customer) {
		Customer customerList = service.getUpdatedCustomer(customer);
		return new ResponseEntity<Customer>(customerList, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getCustomerandBank/{bank_id}")
	@HystrixCommand(fallbackMethod = "myFallBackMethod")
	public ResponseEntity<?> getCustometAndBank(@PathVariable int bank_id) {

		List<Customer> customer = service.getCustomerByBank(bank_id);
		ResponseEntity<?> responseEntity = null;

		if (customer == null) {
			responseEntity = new ResponseEntity<String>("No Customer present with the given id: " + bank_id,
					HttpStatus.NOT_FOUND);
		} else {
			Bank bank = restTemplate.getForObject("http://localhost:8888/bank/getbank/" +bank_id,
					Bank.class);

			CustomerBankResponse response = new CustomerBankResponse();
			response.setCustomer(customer);
			response.setBank(bank);

			responseEntity = new ResponseEntity<CustomerBankResponse>(response, HttpStatus.OK);
		}
		return responseEntity;
	}

	public ResponseEntity<?> myFallBackMethod(@PathVariable int cid) {
		Customer customer = service.getCustomer(cid);
		ResponseEntity<?> responseEntity = null;

		FailureResponse response = new FailureResponse();
		response.setCustomer(service.getCustomers());
		response.setMessage("BANK service is down due to maintainance");
		responseEntity = new ResponseEntity<FailureResponse>(response, HttpStatus.SERVICE_UNAVAILABLE);
		return responseEntity;
	}

}
