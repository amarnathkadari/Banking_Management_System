package com.qsp.banking_managemeny_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.banking_managemeny_system.dto.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
