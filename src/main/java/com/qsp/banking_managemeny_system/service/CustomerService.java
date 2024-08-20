package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.banking_managemeny_system.dao.AccountDao;
import com.qsp.banking_managemeny_system.dao.CardDao;
import com.qsp.banking_managemeny_system.dao.CustomerDao;
import com.qsp.banking_managemeny_system.dao.LoanDao;
import com.qsp.banking_managemeny_system.dto.Account;
import com.qsp.banking_managemeny_system.dto.Card;
import com.qsp.banking_managemeny_system.dto.Customer;
import com.qsp.banking_managemeny_system.dto.Loan;
import com.qsp.banking_managemeny_system.exception.AccountIdNotFound;
import com.qsp.banking_managemeny_system.exception.CardIdNotFound;
import com.qsp.banking_managemeny_system.exception.CustomerIdNotFound;
import com.qsp.banking_managemeny_system.exception.LoanIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructureList<Customer> responseStructureList;
	@Autowired
	AccountDao accountDao;
	@Autowired
	LoanDao loanDao;
	@Autowired
	CardDao cardDao;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.fetchCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomerById(int customerId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.updateCustomerById(customerId, newCustomer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}
		throw new CustomerIdNotFound();
	}

	public ResponseStructureList<Customer> fetchAllCustomer() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAllCustomer());
		return responseStructureList;
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingAccountToExistingCustomer(int accountId,
			int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Account account = accountDao.fetchAccountById(accountId);
		if (customer != null) {
			if (account != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(customerDao.addExistingAccountToExistingCustomer(accountId, customerId));
				return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
			}
			throw new AccountIdNotFound();
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewAccountToExistingCustomer(Account newAccount,
			int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.addNewAccountToExistingCustomer(newAccount, customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingLoanToExistingCustomer(int loanId, int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Loan loan = loanDao.fetchLoanById(loanId);
		if (customer != null) {
			if (loan != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(customerDao.addExistingLoanToExistingCustomer(loanId, customerId));
				return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
			}
			throw new LoanIdNotFound();
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewLoanToExistingCustomer(Loan newLoan, int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.addNewLoanToExistingCustomer(newLoan, customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingCardToExistingCustomer(int cardId, int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		Card card = cardDao.fetchCardById(cardId);
		if (customer != null) {
			if (card != null) {
				responseStructure.setMessage("successfully updated data into database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(customerDao.addExistingCardToExistingCustomer(cardId, customerId));
				return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
			}
			throw new CardIdNotFound();
		}
		throw new CustomerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Customer>> addNewCardToExistingCustomer(Card newCard, int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.addNewCardToExistingCustomer(newCard, customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		}
		throw new CustomerIdNotFound();
	}
}
