package com.blackjack;

import java.util.Collections;
import java.util.Stack;

import com.blackjack.Card.Suit;
import com.blackjack.Card.Value;

public class Deck {

	private Stack<Card> cards = new Stack<>();
	
	public Deck() {
		cards = createDeck();
	}
	
	private Stack<Card> createDeck() {
		Stack<Card> cards = new Stack<>();
		Suit[] suits = Card.Suit.values();
		Value[] values = Card.Value.values();
		for (Suit suit : suits) {
			for (Value value : values) {
				cards.push(new Card(suit, value));
			}
		}
		Collections.shuffle(cards);
		return cards;
	}

	public Card take() {
		if (cards.size() < 5) {
			System.out.println("Shuffling in new deck");
			cards.addAll(createDeck());
		}
		return cards.pop();
	}
	
	public Stack<Card> getCards() {
		return cards;
	}
	
}
