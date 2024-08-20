package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.banking_managemeny_system.dao.AccountDao;
import com.qsp.banking_managemeny_system.dto.Account;
import com.qsp.banking_managemeny_system.exception.AccountIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;

	@Autowired
	ResponseStructure<Account> responseStructure;

	@Autowired
	ResponseStructureList<Account> responseStructureList;

	public ResponseEntity<ResponseStructure<Account>> saveAccount(Account account) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Account>> fetchAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(accountDao.fetchAccountById(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Account>> updateAccountById(int accountId, Account newAccount) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(accountDao.updateAccountById(accountId, newAccount));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(accountDao.deleteAccountById(accountId));
			return new ResponseEntity<ResponseStructure<Account>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructureList<Account> fetchAllAccount() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(accountDao.fetchAllAccount());
		return responseStructureList;
	}
}
