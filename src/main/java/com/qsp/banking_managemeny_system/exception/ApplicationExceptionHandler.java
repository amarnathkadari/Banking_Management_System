package com.qsp.banking_managemeny_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.banking_managemeny_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AccountIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> accountIdNotFound(AccountIdNotFound accountIdNotFound) {
                responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(accountIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BankIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> bankIdNotFound(BankIdNotFound bankIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(bankIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchHeadIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchHeadIdNotFound(BranchHeadIdNotFound branchHeadIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(branchHeadIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CardIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> cardIdNotFound(CardIdNotFound cardIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(cardIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(employeeIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoanIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> loanIdNotFound(LoanIdNotFound loanIdNotFound) {
		responseStructure.setMessage("please  enter the correct id ");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(loanIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
