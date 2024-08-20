package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.banking_managemeny_system.dao.LoanDao;
import com.qsp.banking_managemeny_system.dto.Loan;
import com.qsp.banking_managemeny_system.exception.LoanIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class LoanService {

	@Autowired
	LoanDao loanDao;
	@Autowired
	ResponseStructure<Loan> responseStructure;
	@Autowired
	ResponseStructureList<Loan> responseStructureList;

	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(loanDao.saveLoan(loan));
		return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Loan>> fetchLoanById(int loanId) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(loanDao.fetchLoanById(loanId));
			return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.FOUND);
		}
		throw new LoanIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Loan>> updateLoanById(int loanId, Loan newLoan) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(loanDao.updateLoanById(loanId, newLoan));
			return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.CREATED);
		}
		throw new LoanIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(int loanId) {
		Loan loan = loanDao.fetchLoanById(loanId);
		if (loan != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(loanDao.deleteLoanById(loanId));
			return new ResponseEntity<ResponseStructure<Loan>>(responseStructure, HttpStatus.OK);
		}
		throw new LoanIdNotFound();
	}

	public ResponseStructureList<Loan> fetchAllLoan() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(loanDao.fetchAllLoan());
		return responseStructureList;
	}
}
