/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Toolkit;


import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public GameFrame(){
		
		setTitle("Black Jack");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gamePanel = new GamePanel();
		getContentPane().add(gamePanel);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/black-jack-icon.png"));
		
		setJMenuBar(new MenuBar(this));
		
		pack();
		setVisible(true);
		
		gamePanel.runGame();
		
	}
	
}


