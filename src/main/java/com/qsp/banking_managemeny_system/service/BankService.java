package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.banking_managemeny_system.dao.BankDao;
import com.qsp.banking_managemeny_system.dao.BranchDao;
import com.qsp.banking_managemeny_system.dto.Bank;
import com.qsp.banking_managemeny_system.dto.Branch;
import com.qsp.banking_managemeny_system.exception.BankIdNotFound;
import com.qsp.banking_managemeny_system.exception.BranchIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class BankService {

	@Autowired
	BankDao bankDao;

	@Autowired
	ResponseStructure<Bank> responseStructure;

	@Autowired
	ResponseStructureList<Bank> responseStructureList;

	@Autowired
	BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Bank>> saveBank(Bank bank) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Bank>> fetchBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(bankDao.fetchBankById(bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Bank>> updateBankById(int bankId, Bank newBank) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("successfully inserted data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(bankDao.updateBankById(bankId, newBank));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Bank>> deleteBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("successfully inserted data into database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.deleteBankById(bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructureList<Bank> fetchAllBank() {
		responseStructureList.setMessage("successfully fetched data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(bankDao.fetchAllBank());
		return responseStructureList;
	}

	public ResponseEntity<ResponseStructure<Bank>> addExistingBranchToExistingBank(int branchId, int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		Branch branch = branchDao.fetchBranchById(branchId);
		if (bank != null) {
			if (branch != null) {
				responseStructure.setMessage("successfully inserted data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(bankDao.addExistingBranchToExistingBank(branchId, bankId));
				return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
			}
			throw new BranchIdNotFound();
		}
		throw new BankIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Bank>> addNewBranchToExistingBank(Branch newBranch, int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("successfully inserted data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(bankDao.addNewBranchToExistingBank(newBranch, bankId));
			return new ResponseEntity<ResponseStructure<Bank>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BankIdNotFound();
	}
}
