package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Address;
import com.qsp.banking_managemeny_system.dto.Branch;
import com.qsp.banking_managemeny_system.dto.BranchHead;
import com.qsp.banking_managemeny_system.dto.Customer;
import com.qsp.banking_managemeny_system.dto.Employee;
import com.qsp.banking_managemeny_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	BranchHeadDao branchHeadDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	CustomerDao customerDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int branchId) {
//		return branchRepo.findById(branchId).get();
		Optional<Branch> branch = branchRepo.findById(branchId);
		if (branch.isPresent()) {
			return branch.get();
		}
		return null;
	}

	public Branch updateBranchById(int branchId, Branch newBranch) {
		newBranch.setBranchId(branchId);
		return saveBranch(newBranch);
	}

	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}

	public List<Branch> fetchAllBranch() {
		return branchRepo.findAll();
	}

	public Branch addExistingBranchHeadToExistingBranch(int branchId, int branchHeadId) {
		Branch branch = fetchBranchById(branchId);
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}

	public Branch addExistingAddressToExistingBranch(int addressId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}

	public Branch addNewBranchHeadToExistingBranch(BranchHead newBranchHead, int branchId) {
		Branch branch = fetchBranchById(branchId);
		branch.setBranchHead(newBranchHead);
		return saveBranch(branch);
	}

	public Branch addNewAddressToExistingBranch(Address newAddress, int branchId) {
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(newAddress);
		return saveBranch(branch);
	}

	public Branch addExistingEmployeeToExistingBranch(int employeeId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		List<Employee> list = branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}

	public Branch addNewEmployeeToExistingBranch(Employee newEmployee, int branchId) {
		Branch branch = fetchBranchById(branchId);
		List<Employee> list = branch.getEmployee();
		list.add(newEmployee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}

	public Branch addExistingCustomerToExistingBranch(int customerId, int branchId) {
		Branch branch = fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		List<Customer> list = branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}

	public Branch addNewCustomerToExistingBranch(Customer newCustomer, int branchId) {
		Branch branch = fetchBranchById(branchId);
		List<Customer> list = branch.getCustomer();
		list.add(newCustomer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}

}
