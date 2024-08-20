package com.qsp.banking_managemeny_system.exception;

public class CardIdNotFound extends RuntimeException {

	private String message = "Account Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
