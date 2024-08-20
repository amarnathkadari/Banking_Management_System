package com.qsp.banking_managemeny_system.exception;

public class BranchIdNotFound extends RuntimeException {
	private String message = "Branch Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
