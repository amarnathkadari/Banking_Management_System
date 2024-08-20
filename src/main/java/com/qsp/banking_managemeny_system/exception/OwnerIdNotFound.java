package com.qsp.banking_managemeny_system.exception;

public class OwnerIdNotFound extends RuntimeException {

	private String message = "Owner Id Not Found In The DataBase";

	public String getMessage() {
		return message;
	}

}
