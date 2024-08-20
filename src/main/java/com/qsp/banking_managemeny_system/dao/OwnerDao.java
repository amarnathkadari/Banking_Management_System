package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Bank;
import com.qsp.banking_managemeny_system.dto.Owner;
import com.qsp.banking_managemeny_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	BankDao bankDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
//		return ownerRepo.findById(ownerId).get();
		Optional<Owner> owner = ownerRepo.findById(ownerId);
		if (owner.isPresent()) {
			return owner.get();
		} else {
			return null;
		}
	}

	public Owner updateOwnerById(int ownerId, Owner newOwner) {
		newOwner.setOwnerId(ownerId);
		return saveOwner(newOwner);
	}

	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}

	public Owner addExistingBankToExistingOwner(int ownerId, int bankId) {

		Owner owner = fetchOwnerById(ownerId);
		Bank bank = bankDao.fetchBankById(bankId);
		owner.setBank(bank);
		return saveOwner(owner);
	}

	public Owner addNewBankToExistingOwner(Bank newBank, int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		owner.setBank(newBank);
		return saveOwner(owner);
	}

	public Owner updateOwnerPhone(int ownerId, long newOwnerPhone) {
		Owner owner = fetchOwnerById(ownerId);
		owner.setOwnerPhone(newOwnerPhone);
		return saveOwner(owner);
	}

	public Optional<Owner> findByPhone(long phone) {
		return ownerRepo.findByPhone(phone);
	}

}
