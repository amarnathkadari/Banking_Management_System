package com.qsp.banking_managemeny_system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.banking_managemeny_system.dto.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {

	@Query("select o from Owner o where o.ownerPhone=:ownerPhone")
	Optional<Owner> findByPhone(long ownerPhone);
}
