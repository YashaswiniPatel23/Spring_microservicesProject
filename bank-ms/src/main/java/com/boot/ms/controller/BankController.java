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
import com.boot.ms.entity.Bank;
import com.boot.ms.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	@Autowired
	BankService service;
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getall")
	public ResponseEntity<List<Bank>> getBanks() {
		return new ResponseEntity<List<Bank>>(service.getBanks(), HttpStatus.OK);
	}

	@GetMapping("/getbank/{bank_id}")
	public ResponseEntity<?> getBank(@PathVariable int bank_id) {
		Bank bank = service.getBank(bank_id);
		ResponseEntity<?> responseEntity = null;

		if (bank == null) {
			responseEntity = new ResponseEntity<String>("No Bank present with given id  : " + bank_id,
					HttpStatus.NOT_FOUND);

		} else {
			responseEntity = new ResponseEntity<Bank>(bank, HttpStatus.OK);
		}
		return responseEntity;

	}

	@DeleteMapping("/delete/{bank_id}")
	public ResponseEntity<String> deleteBankById(@PathVariable("bank_id") int bank_id) throws Exception {
		service.deleteBankById(bank_id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<Bank> addBank(@RequestBody Bank bank) {
		return new ResponseEntity<Bank>(service.addBank(bank), HttpStatus.OK);
	}

	@PutMapping("/update")

	public ResponseEntity<Bank> updatedCustomers(@RequestBody Bank bank) {
		Bank bankList = service.getUpdatedBank(bank);
		return new ResponseEntity<Bank>(bankList, HttpStatus.OK);
	}
}
