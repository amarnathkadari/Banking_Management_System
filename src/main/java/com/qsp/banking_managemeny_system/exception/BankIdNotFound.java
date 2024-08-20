package com.qsp.banking_managemeny_system.exception;

public class BankIdNotFound extends RuntimeException {

	private String message = "Bank Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
