package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.BranchHead;
import com.qsp.banking_managemeny_system.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {

	@Autowired
	BranchHeadRepo branchHeadRepo;

	public BranchHead saveBranchHead(BranchHead branchHead) {
		return branchHeadRepo.save(branchHead);
	}

	public BranchHead fetchBranchHeadById(int branchHeadId) {
//		return branchHeadRepo.findById(branchHeadId).get();
		Optional<BranchHead> branchHead = branchHeadRepo.findById(branchHeadId);
		if (branchHead.isPresent()) {
			return branchHead.get();
		}
		return null;
	}

	public BranchHead updateBranchHeadById(int branchHeadId, BranchHead newBranchHead) {
		newBranchHead.setBranchHeadId(branchHeadId);
		return saveBranchHead(newBranchHead);
	}

	public BranchHead deleteBranchHeadById(int branchHeadId) {
		BranchHead branchHead = fetchBranchHeadById(branchHeadId);
		branchHeadRepo.delete(branchHead);
		return branchHead;
	}

	public List<BranchHead> fetchAllBranchHead() {
		return branchHeadRepo.findAll();
	}

}
