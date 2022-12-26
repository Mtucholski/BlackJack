/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import java.util.ArrayList;

/**
 *
 * @author dom
 */
public class Player {

	private final String name;
	private final ArrayList<Card> hand;
	
	public Player (String playerName) {
		hand = new ArrayList<>();
		name = playerName;
	}

	public void addCardToHand(Card newCard) {
		hand.add(newCard);
	}
	
	public int getHandSum() {
		
		int sumOfPoints = 0;
		int cardPoints;
		int numberOfAces = 0;

		for (Card card : hand) {

			cardPoints = card.getCardValue().getValue();

			if (cardPoints == 11) {
				numberOfAces++;
				sumOfPoints += 11;
			} else {
				sumOfPoints += cardPoints;
			}
		}
		
		while (sumOfPoints > 21 && numberOfAces > 0) {
			sumOfPoints -= 10;
			numberOfAces--;
		}
		
		return sumOfPoints;
	}
	
	public String getCardsText(boolean showFirstHand) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < hand.size(); i++) {
			
			if (i == 0 && !showFirstHand) {
				sb.append("<br>[Ukryta]");
			} else {
				sb.append("<br>").append(hand.get(i).toString());
			}
		}
		return sb.toString();
	}
	
	public String getCardsOnHand(boolean showFirstHand) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(name).append(":<br>");
		sb.append(getCardsText(showFirstHand)).append("<br>");
		
		if (showFirstHand) {
			sb.append("Punkty: [").append(getHandSum()).append("] <br>");
		} else {
			sb.append("Punkty: [?] <br>");
		}
		
		sb.append("</html>");
		return sb.toString();
	}
	
	public boolean checkIfBusted() {
		return getHandSum() < 22;
	}
}

