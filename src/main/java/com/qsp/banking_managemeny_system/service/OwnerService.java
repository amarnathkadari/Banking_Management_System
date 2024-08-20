package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.banking_managemeny_system.dao.BankDao;
import com.qsp.banking_managemeny_system.dao.OwnerDao;
import com.qsp.banking_managemeny_system.dto.Bank;
import com.qsp.banking_managemeny_system.dto.Owner;
import com.qsp.banking_managemeny_system.exception.BankIdNotFound;
import com.qsp.banking_managemeny_system.exception.OwnerIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	@Autowired
	BankDao bankDao;
	// response entity is used to update statuscode in postman

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner owner) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerById(int ownerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully updated data in database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			newOwner.setOwnerId(ownerId);
			responseStructure.setData(ownerDao.updateOwnerById(ownerId, newOwner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
		}
		throw new OwnerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully deleted data in database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		}
		throw new OwnerIdNotFound();
	}

	public ResponseStructureList<Owner> fetchAllOwner() {
		responseStructureList.setMessage("successfully fetched data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());

		responseStructureList.setData(ownerDao.fetchAllOwner());
		return responseStructureList;
	}

	public ResponseEntity<ResponseStructure<Owner>> addExistingBankToExistingOwner(int ownerId, int bankId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		Bank bank = bankDao.fetchBankById(bankId);
		if (owner != null) {
			if (bank != null) {
				responseStructure.setMessage("successfully updated data in database");
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setData(ownerDao.addExistingBankToExistingOwner(ownerId, bankId));
				return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
			}
			throw new BankIdNotFound();
		}
		throw new OwnerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Owner>> addNewBankToExistingOwner(Bank newBank, int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully updated data in database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(ownerDao.addNewBankToExistingOwner(newBank, ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
		}
		throw new OwnerIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Owner>> updateOwnerPhone(int ownerId, long newOwnerPhone) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setMessage("successfully updated data in database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(ownerDao.updateOwnerPhone(ownerId, newOwnerPhone));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
		}
		throw new OwnerIdNotFound();

	}

}
