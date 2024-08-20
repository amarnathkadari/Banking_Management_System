package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.banking_managemeny_system.dao.AddressDao;
import com.qsp.banking_managemeny_system.dao.BranchDao;
import com.qsp.banking_managemeny_system.dao.BranchHeadDao;
import com.qsp.banking_managemeny_system.dao.CustomerDao;
import com.qsp.banking_managemeny_system.dao.EmployeeDao;
import com.qsp.banking_managemeny_system.dto.Address;
import com.qsp.banking_managemeny_system.dto.Branch;
import com.qsp.banking_managemeny_system.dto.BranchHead;
import com.qsp.banking_managemeny_system.dto.Customer;
import com.qsp.banking_managemeny_system.dto.Employee;
import com.qsp.banking_managemeny_system.exception.AddressIdNotFound;
import com.qsp.banking_managemeny_system.exception.BranchHeadIdNotFound;
import com.qsp.banking_managemeny_system.exception.BranchIdNotFound;
import com.qsp.banking_managemeny_system.exception.CustomerIdNotFound;
import com.qsp.banking_managemeny_system.exception.EmployeeIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	@Autowired
	BranchHeadDao branchHeadDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int branchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.updateBranchById(branchId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		}
		throw new BranchIdNotFound();
	}

	public ResponseStructureList<Branch> fetchAllBranch() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAllBranch());
		return responseStructureList;
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchHeadToExistingBranch(int branchId,
			int branchHeadId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		if (branch != null) {
			if (branchHead != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(branchDao.addExistingBranchHeadToExistingBranch(branchId, branchHeadId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
			}
			throw new BranchHeadIdNotFound();
		}
		throw new BranchIdNotFound();

	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int addressId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch != null) {
			if (address != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
			}
			throw new AddressIdNotFound();
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewBranchHeadToExistingBranch(BranchHead newBranchHead,
			int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.addNewBranchHeadToExistingBranch(newBranchHead, branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(Address newAddress, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.addNewAddressToExistingBranch(newAddress, branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (branch != null) {
			if (employee != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(employeeId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
			}
			throw new EmployeeIdNotFound();
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(Employee newEmployee,
			int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);

		if (branch != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(newEmployee, branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int customerId, int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (branch != null) {
			if (customer != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(customerId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
			}
			throw new CustomerIdNotFound();
		}
		throw new BranchIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(Customer newCustomer,
			int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(branchDao.addNewCustomerToExistingBranch(newCustomer, branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);
		}
		throw new BranchIdNotFound();
	}
}
