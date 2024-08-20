package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Account;
import com.qsp.banking_managemeny_system.dto.Card;
import com.qsp.banking_managemeny_system.dto.Customer;
import com.qsp.banking_managemeny_system.dto.Loan;
import com.qsp.banking_managemeny_system.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	AccountDao accountDao;

	@Autowired
	LoanDao loanDao;

	@Autowired
	CardDao cardDao;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchCustomerById(int customerId) {
//		return customerRepo.findById(customerId).get();
		Optional<Customer> customer = customerRepo.findById(customerId);
		if (customer.isPresent()) {
			return customer.get();
		}
		return null;
	}

	public Customer updateCustomerById(int customerId, Customer newCustomer) {
		newCustomer.setCustomerId(customerId);
		return saveCustomer(newCustomer);
	}

	public Customer deleteCustomerById(int customerId) {
		Customer customer = fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}

	public List<Customer> fetchAllCustomer() {
		return customerRepo.findAll();
	}

	public Customer addExistingAccountToExistingCustomer(int accountId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		Account account = accountDao.fetchAccountById(accountId);
		List<Account> list = customer.getAccount();
		list.add(account);
		customer.setAccount(list);
		return saveCustomer(customer);
	}

	public Customer addNewAccountToExistingCustomer(Account newAccount, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Account> list = customer.getAccount();
		list.add(newAccount);
		customer.setAccount(list);
		return saveCustomer(customer);
	}

	public Customer addExistingLoanToExistingCustomer(int loanId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		Loan loan = loanDao.fetchLoanById(loanId);
		List<Loan> list = customer.getLoan();
		list.add(loan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}

	public Customer addNewLoanToExistingCustomer(Loan newLoan, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Loan> list = customer.getLoan();
		list.add(newLoan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}

	public Customer addExistingCardToExistingCustomer(int cardId, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		Card card = cardDao.fetchCardById(cardId);
		List<Card> list = customer.getCard();
		list.add(card);
		customer.setCard(list);
		return saveCustomer(customer);
	}

	public Customer addNewCardToExistingCustomer(Card newCard, int customerId) {
		Customer customer = fetchCustomerById(customerId);
		List<Card> list = customer.getCard();
		list.add(newCard);
		customer.setCard(list);
		return saveCustomer(customer);
	}

}
