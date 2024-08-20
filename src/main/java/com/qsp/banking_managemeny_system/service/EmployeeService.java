package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.banking_managemeny_system.dao.EmployeeDao;
import com.qsp.banking_managemeny_system.dto.Employee;
import com.qsp.banking_managemeny_system.exception.EmployeeIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	@Autowired
	ResponseStructureList<Employee> responseStructureList;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		}
		throw new EmployeeIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(int employeeId, Employee newEmployee) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(employeeDao.updateEmployeeById(employeeId, newEmployee));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
		}
		throw new EmployeeIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		}
		throw new EmployeeIdNotFound();
	}

	public ResponseStructureList<Employee> fetchAllEmployee() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(employeeDao.fetchAllEmployee());
		return responseStructureList;
	}
}
