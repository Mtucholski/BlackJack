/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamelogic.NewGameAction;
import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	
	JFrame frame;
	JMenu menu;
	JMenuItem newGameMenuItem;
	JMenuItem quitGameMenuItem;

	public MenuBar(JFrame jframe) {
		
		frame = jframe;
		
		menu = new JMenu("Menu");
		add(menu);
		
		newGameMenuItem = new JMenuItem("Nowa gra");
		newGameMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		newGameMenuItem.addActionListener(new NewGameAction(frame));
		menu.add(newGameMenuItem);
		
		quitGameMenuItem = new JMenuItem("Wyjdz z gry");
		quitGameMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		quitGameMenuItem.addActionListener(e -> System.exit(0));
		menu.add(quitGameMenuItem);

		
	}

}
