/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import blackjack.enums.Suit;
import blackjack.enums.Value;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dom
 */
public class Deck {
	private final ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();

		int suit = 0;
		do {
			for (int value = 0; value < 13; value++) {

				cards.add(new Card(Suit.values()[suit], Value.values()[value]));

			}
			suit++;
		} while (suit < 4);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card handOutCard() {
		return cards.remove(0);
	}
}