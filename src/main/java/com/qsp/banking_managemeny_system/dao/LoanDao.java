package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Loan;
import com.qsp.banking_managemeny_system.repo.LoanRepo;

@Repository
public class LoanDao {

	@Autowired
	LoanRepo loanRepo;

	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}

	public Loan fetchLoanById(int loanId) {
//		return loanRepo.findById(loanId).get();
		Optional<Loan> loan = loanRepo.findById(loanId);
		if (loan.isPresent()) {
			return loan.get();
		}
		return null;
	}

	public Loan updateLoanById(int loanId, Loan newLoan) {
		newLoan.setLoanId(loanId);
		return saveLoan(newLoan);
	}

	public Loan deleteLoanById(int loanId) {
		Loan loan = fetchLoanById(loanId);
		loanRepo.delete(loan);
		return loan;
	}

	public List<Loan> fetchAllLoan() {
		return loanRepo.findAll();
	}
}
