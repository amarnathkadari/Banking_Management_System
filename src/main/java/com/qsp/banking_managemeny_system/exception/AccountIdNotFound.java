package com.qsp.banking_managemeny_system.exception;

public class AccountIdNotFound extends RuntimeException {

	private String message = "Account Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}

}
