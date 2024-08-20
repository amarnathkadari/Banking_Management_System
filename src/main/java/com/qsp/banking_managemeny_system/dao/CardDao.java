package com.qsp.banking_managemeny_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_managemeny_system.dto.Card;
import com.qsp.banking_managemeny_system.repo.CardRepo;

@Repository
public class CardDao {

	@Autowired
	CardRepo cardRepo;

	public Card saveCard(Card card) {
		return cardRepo.save(card);
	}

	public Card fetchCardById(int cardId) {
//		return cardRepo.findById(cardId).get();
		Optional<Card> card = cardRepo.findById(cardId);
		if (card.isPresent()) {
			return card.get();
		}
		return null;
	}

	public Card updateCardById(int cardId, Card newCard) {
		newCard.setCardId(cardId);
		return saveCard(newCard);
	}

	public Card deleteCardById(int cardId) {
		Card card = fetchCardById(cardId);
		cardRepo.delete(card);
		return card;
	}

	public List<Card> fetchAllCard() {
		return cardRepo.findAll();
	}
}
