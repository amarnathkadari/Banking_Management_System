package com.qsp.banking_managemeny_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.banking_managemeny_system.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
