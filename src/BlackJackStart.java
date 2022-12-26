/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gui.GameFrame;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author dom
 */
public class BlackJackStart {
    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");

        } catch (UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {

            System.out.println( e.getCause() + ":" + "" + e.getMessage());

        } catch (ClassNotFoundException e) {

            System.out.println(e.getException() + ":" + "" + e.getCause());

        }

		new GameFrame();
    }
}

