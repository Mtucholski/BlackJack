/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gamelogic.PassCardAction;
import gamelogic.TakeCardAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * @author dom
 */
public class LowerButtonPanel extends JPanel {
	
	private final JButton takeCardButton = new JButton("Weź nową kartę");
	private final JButton passButton = new JButton("Nic nie rób");

	/**
     * Method for setting lower button panel size.
     * @param width  of lower button panel
     * @param height of lower button panel
     * @param gamePanel game panel
     */
    public LowerButtonPanel(int width, int height, GamePanel gamePanel) {
		setPreferredSize(new Dimension(width,height));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		Color backgroundColor = Color.white;
		setBackground(backgroundColor);
		
		takeCardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		passButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		takeCardButton.addActionListener(new TakeCardAction(gamePanel));
		passButton.addActionListener(new PassCardAction(gamePanel));
		
		add(takeCardButton);
		add(passButton);
	}
	
	public void disableButtons() {
		takeCardButton.setEnabled(false);
		passButton.setEnabled(false);
	}

}
