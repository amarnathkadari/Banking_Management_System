package com.qsp.banking_managemeny_system.exception;

public class BranchHeadIdNotFound extends RuntimeException {

	private String message = "BranchHead Id Not Found in The DataBase";

	public String getMessage() {
		return message;
	}
}
