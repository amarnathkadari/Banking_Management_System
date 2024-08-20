package com.qsp.banking_managemeny_system.exception;

public class LoanIdNotFound extends RuntimeException {

	private String message = "Loan Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}

}
