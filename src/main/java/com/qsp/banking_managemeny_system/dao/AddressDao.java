package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Address;
import com.qsp.banking_managemeny_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address fetchAddressById(int addressId) {

//		return addressRepo.findById(addressId).get();
		Optional<Address> address = addressRepo.findById(addressId);
		if (address.isPresent()) {
			return address.get();
		} else {
			return null;
		}
	}

	public Address updateAddressById(int addressId, Address newAddress) {
		newAddress.setAddressId(addressId);
		return saveAddress(newAddress);
	}

	public Address deleteAddressById(int addressId) {
		Address address = fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}

	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
