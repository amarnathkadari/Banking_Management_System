package com.qsp.banking_managemeny_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_managemeny_system.dto.Card;
import com.qsp.banking_managemeny_system.service.CardService;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@RestController
public class CardController {

	@Autowired
	CardService cardService;

	@PostMapping("/saveCard")
	public ResponseEntity<ResponseStructure<Card>> saveCard(@RequestBody Card card) {
		return cardService.saveCard(card);
	}

	@GetMapping("/fetchCardById")
	public ResponseEntity<ResponseStructure<Card>> fetchCardById(@RequestParam int cardId) {
		return cardService.fetchCardById(cardId);
	}

	@PutMapping("/updateCardById")
	public ResponseEntity<ResponseStructure<Card>> updateCardById(@RequestParam int cardId, @RequestBody Card newCard) {
		return cardService.updateCardById(cardId, newCard);
	}

	@DeleteMapping("/deleteCardById")
	public ResponseEntity<ResponseStructure<Card>> deleteCardById(@RequestParam int cardId) {
		return cardService.deleteCardById(cardId);
	}

	@GetMapping("/fetchAllCard")
	public ResponseStructureList<Card> fetchAllCard() {
		return cardService.fetchAllCard();
	}
}
