package com.qsp.banking_managemeny_system.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Account;
import com.qsp.banking_managemeny_system.repo.AccountRepo;

@Repository
public class AccountDao {

	@Autowired
	AccountRepo accountRepo;

	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	public Account fetchAccountById(int accountId) {
//		return accountRepo.findById(accountId).get();
		Optional<Account> account = accountRepo.findById(accountId);
		if (account.isPresent()) {
			return account.get();
		} else {
			return null;
		}
	}

	public Account updateAccountById(int accountId, Account newAccount) {
		newAccount.setAccountId(accountId);
		return saveAccount(newAccount);

	}

	public Account deleteAccountById(int accountId) {
		Account account = fetchAccountById(accountId);
		accountRepo.delete(account);
		return account;
	}

	public List<Account> fetchAllAccount() {
		return accountRepo.findAll();
	}
}
