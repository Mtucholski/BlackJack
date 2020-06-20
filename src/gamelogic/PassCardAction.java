/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

/**
 *
 * @author dom
 */


import gui.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassCardAction implements ActionListener {

	private GamePanel game;
	
	public PassCardAction(GamePanel game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.doDealerTurn();
		game.finishGame();
	}
	
}

