package com.qsp.banking_managemeny_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	private String bankName;
	private String bankGST;
	private long bankPhone;
	private String bankEmail;

	@OneToMany(cascade = CascadeType.ALL)
	List<Branch> branch;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankGST() {
		return bankGST;
	}

	public void setBankGST(String bankGST) {
		this.bankGST = bankGST;
	}

	public long getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(long bankPhone) {
		this.bankPhone = bankPhone;
	}

	public String getBankEmail() {
		return bankEmail;
	}

	public void setBankEmail(String bankEmail) {
		this.bankEmail = bankEmail;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

}
