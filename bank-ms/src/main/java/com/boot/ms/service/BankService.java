package com.boot.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.ms.entity.Bank;
import com.boot.ms.repository.BankRepository;

@Service
public class BankService {
	@Autowired
	BankRepository repository;

	public List<Bank> getBanks() {
		return repository.findAll();

	}

	public void saveOrUpdate(Bank bank) {
		repository.save(bank);
	}

	public Bank getBank(int bank_id) {
		return repository.findById(bank_id).orElse(null);
	}

	public void deleteBankById(int bank_id) {
		repository.deleteById(bank_id);
	}

	public Bank addBank(Bank bank) {
		return repository.save(bank);
	}

	public Bank getUpdatedBank(Bank bank) {
		Bank bankData = repository.findById(bank.getId()).get();
		bankData.setId(bank.getId());
		bankData.setName(bank.getName());
		bankData.setCity(bank.getCity());
		return repository.save(bankData);
	}

}
