package com.qsp.banking_managemeny_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_managemeny_system.dto.Account;
import com.qsp.banking_managemeny_system.service.AccountService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/saveAccount")
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@GetMapping("/fetchAccountById")
	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(@RequestParam int accountId) {
		return accountService.fetchAccountById(accountId);
	}

	@PutMapping("/updateAccountById")
	public ResponseEntity<ResponseStructure<Account>> updateAccountById(@RequestParam int accountId,
			@RequestBody Account newAccount) {
		return accountService.updateAccountById(accountId, newAccount);

	}

	@DeleteMapping("/deleteAccountById")
	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}

	@GetMapping("/fetchAllAccount")
	public ResponseStructureList<Account> fetchAllAccount() {
		return accountService.fetchAllAccount();
	}
}
