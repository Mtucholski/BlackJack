/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelogic;

import gamelogic.Deck;
import java.util.Scanner;

/**
 *
 * @author dom
 */


public class Game {
	
	Scanner scanner;
	Deck deck;
	Player player;
	Player dealer;
	
	public Game() {
		
		scanner = new Scanner(System.in);
		deck = new Deck();
		deck.shuffle();
		
		player = new Player("Ja");
		dealer = new Player("Komputer");
		
	}
	
	public void runGame() {
		
		System.out.println("== Gra Black Jack ==");
		
		player.addCardToHand(deck.handOutCard());
		dealer.addCardToHand(deck.handOutCard());
		
		player.addCardToHand(deck.handOutCard());
		dealer.addCardToHand(deck.handOutCard());
		
		System.out.println();
		
		
		boolean playerInGame = true;
		boolean dealerInGame = true;
		String answer;
		
		while (playerInGame || dealerInGame) {
			
			if (playerInGame) {
				
				System.out.println("Dobrać kartę? (Wpisz T lub N)");
				answer = scanner.next();
				
				if (answer.compareToIgnoreCase("T") == 0) {
					
					System.out.println("\nDobierasz kartę \n");
					
					player.addCardToHand(deck.handOutCard());
					playerInGame = !player.checkIfBusted();
					
				} else {
					
					System.out.println("\nNie dobierasz karty \n");
					playerInGame = false;
					
				}
				
			}
			
			if (dealerInGame) {
				
				if (dealer.getHandSum() < 17) {
					
					System.out.println("\nKrupier dobiera kartę \n");
					dealer.addCardToHand(deck.handOutCard());
					dealerInGame = !dealer.checkIfBusted();
					
				} else {
					System.out.println("\nKrupier nie dobiera karty \n");
					dealerInGame = false;
				}	
			}
		}
		
		scanner.close();
		
		System.out.println("== Koniec gry ==");
		

		
		int playerSum = player.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if (playerSum > dealerSum && playerSum <= 21 || dealerSum > 21) {
			System.out.println("Wygrałeś!");
		} else {
			System.out.println("Krupier wygrał!");
		}
	}
}

    

