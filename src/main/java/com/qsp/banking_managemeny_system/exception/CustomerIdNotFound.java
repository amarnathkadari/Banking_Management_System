package com.qsp.banking_managemeny_system.exception;

public class CustomerIdNotFound extends RuntimeException {

	private String message = "Customer Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
