package com.qsp.banking_managemeny_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.banking_managemeny_system.dao.CardDao;
import com.qsp.banking_managemeny_system.dto.Card;
import com.qsp.banking_managemeny_system.exception.CardIdNotFound;
import com.qsp.banking_managemeny_system.util.ResponseStructure;
import com.qsp.banking_managemeny_system.util.ResponseStructureList;

@Service
public class CardService {

	@Autowired
	CardDao cardDao;
	@Autowired
	ResponseStructure<Card> responseStructure;
	@Autowired
	ResponseStructureList<Card> responseStructureList;

	public ResponseEntity<ResponseStructure<Card>> saveCard(Card card) {
		responseStructure.setMessage("successfully inserted data into database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(cardDao.saveCard(card));
		return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Card>> fetchCardById(int cardId) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("successfully fetched data from database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(cardDao.fetchCardById(cardId));
			return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.FOUND);
		}
		throw new CardIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Card>> updateCardById(int cardId, Card newCard) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("successfully updated data into database");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(cardDao.updateCardById(cardId, newCard));
			return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.CREATED);
		}
		throw new CardIdNotFound();
	}

	public ResponseEntity<ResponseStructure<Card>> deleteCardById(int cardId) {
		Card card = cardDao.fetchCardById(cardId);
		if (card != null) {
			responseStructure.setMessage("successfully deleted data from database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(cardDao.deleteCardById(cardId));
			return new ResponseEntity<ResponseStructure<Card>>(responseStructure, HttpStatus.OK);
		}
		throw new CardIdNotFound();
	}

	public ResponseStructureList<Card> fetchAllCard() {
		responseStructureList.setMessage("successfully fetched all the data from database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(cardDao.fetchAllCard());
		return responseStructureList;
	}
}
