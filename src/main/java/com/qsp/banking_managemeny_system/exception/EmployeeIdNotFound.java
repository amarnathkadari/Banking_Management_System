package com.qsp.banking_managemeny_system.exception;

public class EmployeeIdNotFound extends RuntimeException {

	private String message = "Employee Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
