package gamelogic;
import blackjack.enums.Suit;
import blackjack.enums.Value;

/**
 *
 * @author dom
 */
public class Card {
	
	private Suit cardSuit;
	private Value cardValue;
	
	public Card(Suit suit, Value value) {
		cardSuit = suit;
		cardValue = value;
	}
	
	public Value getCardValue() {
		return cardValue;
	}
	
	public Suit getCardSuit() {
		return cardSuit;
	}
	
	@Override
	public String toString() {
		return cardValue.toString() + " " + cardSuit.toString();
	}
}
