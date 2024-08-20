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

import com.qsp.banking_managemeny_system.dto.BranchHead;
import com.qsp.banking_managemeny_system.service.BranchHeadService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class BranchHeadController {

	@Autowired
	BranchHeadService branchHeadService;

	@PostMapping("/saveBranchHead")
	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}

	@GetMapping("/fetchBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.fetchBranchHeadById(branchHeadId);
	}

	@PutMapping("/updateBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(@RequestParam int branchHeadId,
			@RequestBody BranchHead newBranchHead) {
		return branchHeadService.updateBranchHeadById(branchHeadId, newBranchHead);
	}

	@DeleteMapping("/deleteBranchHeadById")
	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(@RequestParam int branchHeadId) {
		return branchHeadService.deleteBranchHeadById(branchHeadId);
	}

	@GetMapping("/fetchAllBranchHead")
	public ResponseStructureList<BranchHead> fetchAllBranchHead() {
		return branchHeadService.fetchAllBranchHead();
	}
}
