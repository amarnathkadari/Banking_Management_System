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
import com.qsp.banking_managemeny_system.dto.Card;
import com.qsp.banking_managemeny_system.dto.Customer;
import com.qsp.banking_managemeny_system.dto.Loan;
import com.qsp.banking_managemeny_system.service.CustomerService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}

	@PutMapping("/updateCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(@RequestParam int customerId,
			@RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(customerId, newCustomer);
	}

	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}

	@GetMapping("/fetchAllCustomer")
	public ResponseStructureList<Customer> fetchAllCustomer() {
		return customerService.fetchAllCustomer();
	}

	@PutMapping("/addExistingAccountToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingAccountToExistingCustomer(@RequestParam int accountId,
			@RequestParam int customerId) {
		return customerService.addExistingAccountToExistingCustomer(accountId, customerId);
	}

	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewAccountToExistingCustomer(@RequestBody Account newAccount,
			@RequestParam int customerId) {
		return customerService.addNewAccountToExistingCustomer(newAccount, customerId);
	}

	@PutMapping("/addExistingLoanToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingLoanToExistingCustomer(@RequestParam int loanId,
			@RequestParam int customerId) {
		return customerService.addExistingLoanToExistingCustomer(loanId, customerId);
	}

	@PutMapping("/addNewLoanToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewLoanToExistingCustomer(@RequestBody Loan newLoan,
			@RequestParam int customerId) {
		return customerService.addNewLoanToExistingCustomer(newLoan, customerId);
	}

	@PutMapping("/addExistingCardToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingCardToExistingCustomer(@RequestParam int cardId,
			@RequestParam int customerId) {
		return customerService.addExistingCardToExistingCustomer(cardId, customerId);
	}

	@PutMapping("/addNewCardToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewCardToExistingCustomer(@RequestBody Card newCard,
			@RequestParam int customerId) {
		return customerService.addNewCardToExistingCustomer(newCard, customerId);
	}
}
