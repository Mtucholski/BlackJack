/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import gamelogic.Player;
import gamelogic.Deck;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private Deck deck;
	private Player player;
	private Player dealer;

	private final Dimension panelSize = new Dimension(600, 400);
	private final Color backgroundColor = Color.white;
	
	private PlayerPanel playerPanel;
	private PlayerPanel dealerPanel;
	private LowerButtonPanel lowerPanel;
	
	public GamePanel() {
		
		deck = new Deck();
		deck.shuffle();
		player = new Player("Ja");
		dealer = new Player("Krupier");
		
		setPreferredSize(panelSize);
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
				dealerInGame = !dealer.checkIfBusted();
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

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getDealer() {
		return dealer;
	}

	public void setDealer(Player dealer) {
		this.dealer = dealer;
	}

	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}

	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}

	public PlayerPanel getDealerPanel() {
		return dealerPanel;
	}

	public void setDealerPanel(PlayerPanel dealerPanel) {
		this.dealerPanel = dealerPanel;
	}

	public LowerButtonPanel getLowerPanel() {
		return lowerPanel;
	}

	public void setLowerPanel(LowerButtonPanel lowerPanel) {
		this.lowerPanel = lowerPanel;
	}
	
}