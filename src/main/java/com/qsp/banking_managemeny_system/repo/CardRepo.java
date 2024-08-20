package com.qsp.banking_managemeny_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.banking_managemeny_system.dto.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {

}
