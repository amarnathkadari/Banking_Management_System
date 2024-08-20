package com.qsp.banking_managemeny_system.exception;

public class AddressIdNotFound extends RuntimeException {

	private String message = "Address Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
