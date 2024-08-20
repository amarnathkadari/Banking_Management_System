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

import com.qsp.banking_managemeny_system.dto.Loan;
import com.qsp.banking_managemeny_system.service.LoanService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class LoanController {

	@Autowired
	LoanService loanService;

	@PostMapping("/saveLoan")
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}

	@GetMapping("/fetchLoanById")
	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
	}

	@PutMapping("/updateLoanById")
	public ResponseEntity<ResponseStructure<Loan>> updateLoanById(@RequestParam int loanId, @RequestBody Loan newLoan) {
		return loanService.updateLoanById(loanId, newLoan);
	}

	@DeleteMapping("/deleteLoanById")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(@RequestParam int loanId) {
		return loanService.deleteLoanById(loanId);
	}

	@GetMapping("/fetchAllLoan")
	public ResponseStructureList<Loan> fetchAllLoan() {
		return loanService.fetchAllLoan();
	}
}
