package com.boot.ms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.ms.entity.Customer;
import com.boot.ms.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository repository;

	public List<Customer> getCustomers() {
		return repository.findAll();

	}

	public Customer getCustomer(int cid) {
		return repository.findById(cid).orElse(null);
	}

	public void deleteCustomerById(int cid) {
		repository.deleteById(cid);
	}

	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer getUpdatedCustomer(Customer customer) {
		Customer customerData = repository.findById(customer.getId()).get();
		customerData.setId(customer.getId());
		customerData.setName(customer.getName());
		customerData.setCity(customer.getCity());
		customerData.setBank_id(customer.getBank_id());
		return repository.save(customerData);
	
	}
	public List<Customer> getCustomerByBank(int bank_id){
		return repository.findByBankId(bank_id);
	}
}
