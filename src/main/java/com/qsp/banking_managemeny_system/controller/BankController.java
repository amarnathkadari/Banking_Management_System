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

import com.qsp.banking_managemeny_system.dto.Bank;
import com.qsp.banking_managemeny_system.dto.Branch;
import com.qsp.banking_managemeny_system.service.BankService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class BankController {

	@Autowired
	BankService bankService;

	@PostMapping("/saveBank")
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}

	@GetMapping("/fetchBankById")
	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}

	@PutMapping("/updateBankById")
	public ResponseEntity<ResponseStructure<Bank>> updateBankById(@RequestParam int bankId, @RequestBody Bank newBank) {

		return bankService.updateBankById(bankId, newBank);
	}

	@DeleteMapping("/deleteBankById")
	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(@RequestParam int bankId) {

		return bankService.deleteBankById(bankId);
	}

	@GetMapping("/fetchAllBank")
	public ResponseStructureList<Bank> fetchAllBank() {
		return bankService.fetchAllBank();
	}

	@PutMapping("/addExistingBranchToExistingBank")
	public ResponseEntity<ResponseStructure<Bank>> addExistingBranchToExistingBank(@RequestParam int branchId,
			@RequestParam int bankId) {
		return bankService.addExistingBranchToExistingBank(branchId, bankId);
	}

	@PutMapping("/addNewBranchToExistingBank")
	public ResponseEntity<ResponseStructure<Bank>> addNewBranchToExistingBank(@RequestBody Branch newBranch,
			@RequestParam int bankId) {
		return bankService.addNewBranchToExistingBank(newBranch, bankId);
	}
}
