/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import gamelogic.Deck;
import gamelogic.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	
	private final Deck deck;
	private final Player player;
	private final Player dealer;

	private final PlayerPanel playerPanel;
	private final PlayerPanel dealerPanel;
	private final LowerButtonPanel lowerPanel;
	
	public GamePanel() {
		
		deck = new Deck();
		deck.shuffle();
		player = new Player("Ja");
		dealer = new Player("Krupier");

		Dimension panelSize = new Dimension(600, 400);
		setPreferredSize(panelSize);
		Color backgroundColor = Color.white;
		setBackground(backgroundColor);
		setLayout(new BorderLayout());
		
		playerPanel = new PlayerPanel(300,150);
		dealerPanel = new PlayerPanel(300,150);
		lowerPanel = new LowerButtonPanel(600, 50, this);
		
		add(playerPanel, BorderLayout.WEST);
		add(dealerPanel, BorderLayout.EAST);
		add(lowerPanel, BorderLayout.SOUTH);
		
	}
	
	public void runGame() {
		
		player.addCardToHand(deck.handOutCard());
		dealer.addCardToHand(deck.handOutCard());
		player.addCardToHand(deck.handOutCard());
		dealer.addCardToHand(deck.handOutCard());
		
		playerPanel.setText(player.getCardsOnHand(true));
		dealerPanel.setText(dealer.getCardsOnHand(false));
		
	}
	
	public void doDealerTurn() {
		
		boolean dealerInGame = true;
		
		while (dealerInGame) {
			if (dealer.getHandSum() < 17) {
				
				dealer.addCardToHand(deck.handOutCard());
				dealerInGame = dealer.checkIfBusted();
				dealerPanel.setText(dealer.getCardsOnHand(false));
				
			} else {
				dealerInGame = false;
			}
		}
	}
	
	public void finishGame() {
		
		lowerPanel.disableButtons();
		
		int playerSum = player.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if (playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) {
			playerPanel.setWinnerLabelText("<html> <b> Wygrałeś! </b> </html>");
		} else {
			dealerPanel.setWinnerLabelText("<html> <b> Krupier wygrał! </b> </html>");
		}
		
		playerPanel.setText(player.getCardsOnHand(true));
		dealerPanel.setText(dealer.getCardsOnHand(true));
		
	}
	
	public Deck getDeck() {
		return deck;
	}

	public Player getPlayer() {
		return player;
	}

	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}

	
}