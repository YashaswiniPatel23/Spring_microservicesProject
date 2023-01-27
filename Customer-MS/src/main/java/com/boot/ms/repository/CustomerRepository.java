package com.boot.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.ms.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query(name = "findQuery", value = "select a from Customer a where a.bank_id = :bank_id")
	public List<Customer> findByBankId(int bank_id);

}

