//package cecs343_bs_in_cs;
import java.util.*;

import javax.swing.ImageIcon;

public class Deck {
	
	private Stack<GameCard> listOfActiveCards;
	private Stack<GameCard> listOfDiscardedCards;
	private List<GameCard> listOfDisabledCards;
	private static String gameCardImage1 = "src/GameCard 1.png";
	private static String gameCardImage2 = "src/GameCard 2.png";
	private static String gameCardImage3 = "src/GameCard 3.png";
	private static String gameCardImage4 = "src/GameCard 4.png";
	
	public Deck() {
		
		//Creates game card images
		GameCard gameCard1 = new GameCard("Meet The Dean", new ImageIcon(gameCardImage1));
		GameCard gameCard2 = new GameCard("CECS 100", new ImageIcon(gameCardImage2));
		GameCard gameCard3 = new GameCard("The Outpost", new ImageIcon(gameCardImage3));
		GameCard gameCard4 = new GameCard("Goodbye, professor", new ImageIcon(gameCardImage4));
		
		//Adds game card images to list of active cards
		listOfActiveCards.add(gameCard1);
		listOfActiveCards.add(gameCard2);
		listOfActiveCards.add(gameCard3);
		listOfActiveCards.add(gameCard4);
	}
	
	public void shuffle() {
		
	}
	
	public void activate() {
		
	}
	
	public void disable() {
		
	}
}
