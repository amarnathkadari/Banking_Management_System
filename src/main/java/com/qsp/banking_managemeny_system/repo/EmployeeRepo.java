package com.qsp.banking_managemeny_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.banking_managemeny_system.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
