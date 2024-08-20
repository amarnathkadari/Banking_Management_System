package com.qsp.banking_managemeny_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_managemeny_system.dto.Bank;
import com.qsp.banking_managemeny_system.dto.Owner;
import com.qsp.banking_managemeny_system.service.OwnerService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}

	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}

	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(@RequestParam int ownerId,
			@RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(ownerId, newOwner);
	}

	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}

	@GetMapping("/fetchAllOwner")
	public ResponseStructureList<Owner> fetchAllOwner() {
		return ownerService.fetchAllOwner();
	}

	@PutMapping("/addExistingBankToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingBankToExistingOwner(@RequestParam int ownerId,
			@RequestParam int bankId) {
		return ownerService.addExistingBankToExistingOwner(ownerId, bankId);
	}

	@PutMapping("/addNewBankToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addNewBankToExistingOwner(@RequestBody Bank newBank,
			@RequestParam int ownerId) {
		return ownerService.addNewBankToExistingOwner(newBank, ownerId);
	}

	@PatchMapping("/updateOwnerPhone")
	public ResponseEntity<ResponseStructure<Owner>> updateOwnerPhone(@RequestParam int ownerId,
			@RequestParam long newOwnerPhone) {
		return ownerService.updateOwnerPhone(ownerId, newOwnerPhone);
	}
}
