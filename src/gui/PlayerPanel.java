/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	
	private JLabel textLabel = new JLabel();
	private JLabel winnerLabel = new JLabel();
	private final Color backgroundColor = Color.white;
	
	public PlayerPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		setBackground(backgroundColor);
		setBorder(new EmptyBorder(10, 10, 10, 10));

		setLayout(new BorderLayout());   
		add(textLabel, BorderLayout.NORTH);
		add(winnerLabel, BorderLayout.SOUTH);
	}

	public void setText(String text) {
		textLabel.setText(text);
	}
	
	public void setWinnerLabelText(String text) {
		winnerLabel.setText(text);
	}

}