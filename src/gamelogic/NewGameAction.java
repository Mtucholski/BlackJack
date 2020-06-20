/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;
import gui.GameFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NewGameAction implements ActionListener {
	
	JFrame frame;
	
	public NewGameAction (JFrame jframe) {
		frame = jframe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		frame.dispose();
		new GameFrame();
		
	}

}