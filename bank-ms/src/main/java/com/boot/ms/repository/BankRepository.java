package com.boot.ms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.ms.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

	void deleteById(int bank_id);
	
	  @Transactional
	  
	  @Modifying
	  
	  @Query("delete from Bank where bank_id = bank_id") 
	  public void deleteBankById();
	  
	 
		/*
		 * @Query(name = "deleteCustomerBank", value =
		 * "delete from Customer a where a.bank_id =: bank_id") public void
		 * deleteCustomerBank();
		 */
	 

}
	

