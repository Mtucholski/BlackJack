/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import gui.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dom
 */
public class TakeCardAction implements ActionListener {
	
	private GamePanel game;
	boolean playerInGame = true;
	
	public TakeCardAction(GamePanel game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		game.getPlayer().addCardToHand(game.getDeck().handOutCard());
		playerInGame = !game.getPlayer().checkIfBusted();
		game.getPlayerPanel().setText(game.getPlayer().getCardsOnHand(true));
		
		if (!playerInGame) {
			game.finishGame();
		}
	}

}
