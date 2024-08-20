package com.qsp.banking_managemeny_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BranchHead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchHeadId;
	private String branchHeadName;
	private int branchHeadAge;
	private long branchHeadPhone;
	private double branchHeadSalary;
	private String branchHeadEmail;

	public int getBranchHeadId() {
		return branchHeadId;
	}

	public void setBranchHeadId(int branchHeadId) {
		this.branchHeadId = branchHeadId;
	}

	public int getBranchHeadAge() {
		return branchHeadAge;
	}

	public void setBranchHeadAge(int branchHeadAge) {
		this.branchHeadAge = branchHeadAge;
	}

	public String getBranchHeadName() {
		return branchHeadName;
	}

	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}

	public long getBranchHeadPhone() {
		return branchHeadPhone;
	}

	public void setBranchHeadPhone(long branchHeadPhone) {
		this.branchHeadPhone = branchHeadPhone;
	}

	public double getBranchHeadSalary() {
		return branchHeadSalary;
	}

	public void setBranchHeadSalary(double branchHeadSalary) {
		this.branchHeadSalary = branchHeadSalary;
	}

	public String getBranchHeadEmail() {
		return branchHeadEmail;
	}

	public void setBranchHeadEmail(String branchHeadEmail) {
		this.branchHeadEmail = branchHeadEmail;
	}

}
