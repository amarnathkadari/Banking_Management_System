package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.banking_managemeny_system.dao.BranchHeadDao;
import com.qsp.banking_managemeny_system.dto.BranchHead;
import com.qsp.banking_managemeny_system.exception.BranchHeadIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class BranchHeadService {

	@Autowired
	BranchHeadDao branchHeadDao;
	@Autowired
	ResponseStructure<BranchHead> responseStructure;
	@Autowired
	ResponseStructureList<BranchHead> responseStructureList;

	public ResponseEntity<ResponseStructure<BranchHead>> saveBranchHead(BranchHead branchHead) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<BranchHead>> fetchBranchHeadById(int branchHeadId) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		if (branchHead != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchHeadDao.fetchBranchHeadById(branchHeadId));
			return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.FOUND);
		}
		throw new BranchHeadIdNotFound();
	}

	public ResponseEntity<ResponseStructure<BranchHead>> updateBranchHeadById(int branchHeadId,
			BranchHead newBranchHead) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		if (branchHead != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchHeadDao.updateBranchHeadById(branchHeadId, newBranchHead));
			return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BranchHeadIdNotFound();
	}

	public ResponseEntity<ResponseStructure<BranchHead>> deleteBranchHeadById(int branchHeadId) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		if (branchHead != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchHeadDao.deleteBranchHeadById(branchHeadId));
			return new ResponseEntity<ResponseStructure<BranchHead>>(responseStructure, HttpStatus.OK);
		}
		throw new BranchHeadIdNotFound();
	}

	// later
	public ResponseStructureList<BranchHead> fetchAllBranchHead() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchHeadDao.fetchAllBranchHead());
		return responseStructureList;
	}
}
