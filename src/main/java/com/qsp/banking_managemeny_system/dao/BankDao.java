package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Bank;
import com.qsp.banking_managemeny_system.dto.Branch;
import com.qsp.banking_managemeny_system.repo.BankRepo;

@Repository
public class BankDao {

	@Autowired
	BankRepo bankRepo;

	@Autowired
	BranchDao branchDao;

	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}

	public Bank fetchBankById(int bankId) {

//		return bankRepo.findById(bankId).get();
		Optional<Bank> bank = bankRepo.findById(bankId);
		if (bank.isPresent()) {
			return bank.get();
		} else {
			return null;
		}
	}

	public Bank updateBankById(int bankId, Bank newBank) {
		newBank.setBankId(bankId);
		return saveBank(newBank);
	}

	public Bank deleteBankById(int bankId) {
		Bank bank = fetchBankById(bankId);
		bankRepo.delete(bank);
		return bank;
	}

	public List<Bank> fetchAllBank() {
		return bankRepo.findAll();
	}

	public Bank addExistingBranchToExistingBank(int branchId, int bankId) {
		Bank bank = fetchBankById(bankId);
		Branch branch = branchDao.fetchBranchById(branchId);

		List<Branch> list = bank.getBranch();
		list.add(branch);

		bank.setBranch(list);

		return saveBank(bank);

	}

	public Bank addNewBranchToExistingBank(Branch newBranch, int bankId) {
		Bank bank = fetchBankById(bankId);
		List<Branch> list = bank.getBranch();
		list.add(newBranch);

		bank.setBranch(list);

		return saveBank(bank);

	}
}
