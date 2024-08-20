package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Employee;
import com.qsp.banking_managemeny_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int employeeId) {
//		return employeeRepo.findById(employeeId).get();
		Optional<Employee> employee = employeeRepo.findById(employeeId);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;

	}

	public Employee updateEmployeeById(int employeeId, Employee newEmployee) {
		newEmployee.setEmployeeId(employeeId);
		return saveEmployee(newEmployee);
	}

	public Employee deleteEmployeeById(int employeeId) {
		Employee employee = fetchEmployeeById(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}

	public List<Employee> fetchAllEmployee() {
		return employeeRepo.findAll();
	}
}
