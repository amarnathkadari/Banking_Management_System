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

import com.qsp.banking_managemeny_system.dto.Address;
import com.qsp.banking_managemeny_system.dto.Branch;
import com.qsp.banking_managemeny_system.dto.BranchHead;
import com.qsp.banking_managemeny_system.dto.Customer;
import com.qsp.banking_managemeny_system.dto.Employee;
import com.qsp.banking_managemeny_system.service.BranchService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int branchId,
			@RequestBody Branch newBranch) {
		return branchService.updateBranchById(branchId, newBranch);
	}

	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	@GetMapping("/fetchAllBranch")
	public ResponseStructureList<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	@PutMapping("/addExistingBranchHeadToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBranch(@RequestParam int branchId,
			@RequestParam int branchHeadId) {
		return branchService.addExistingBranchHeadToExistingBranch(branchId, branchHeadId);
	}

	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int addressId,
			@RequestParam int branchId) {

		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}

	@PutMapping("/addNewBranchHeadToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewBranchHeadToExistingBranch(
			@RequestBody BranchHead newBranchHead, @RequestParam int branchId) {

		return branchService.addNewBranchHeadToExistingBranch(newBranchHead, branchId);
	}

	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(@RequestBody Address newAddress,
			@RequestParam int branchId) {

		return branchService.addNewAddressToExistingBranch(newAddress, branchId);
	}

	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(@RequestParam int employeeId,
			@RequestParam int branchId) {
		return branchService.addExistingEmployeeToExistingBranch(employeeId, branchId);
	}

	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(@RequestBody Employee newEmployee,
			@RequestParam int branchId) {
		return branchService.addNewEmployeeToExistingBranch(newEmployee, branchId);
	}

	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(@RequestParam int customerId,
			@RequestParam int branchId) {
		return branchService.addExistingCustomerToExistingBranch(customerId, branchId);
	}

	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(@RequestBody Customer newCustomer,
			@RequestParam int branchId) {
		return branchService.addNewCustomerToExistingBranch(newCustomer, branchId);
	}

}
