package cecs343_bs_in_cs;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 * Special Game Card Details
 *
 * Cards that reward players with a chip of choice 11 12 24 26 27 28 32 35 36 37
 * 
 * Cards that reward players with a card(s) 25 30 31 33
 * 
 * Cards that punish players by discarding a game card of their choice 8 10 17
 * 24 25 27 28 32 37
 * 
 * Cards that teleport a player 13 15 16 21 22 23 30 33 34 38 39
 */
public abstract class GameCard {

	protected String gameCardName, gameCardAction;
	private ImageIcon gameCardImage;
	protected ArrayList<Room> listOfValidRooms;
	protected int learningPreReq, craftPreReq, integrityPreReq;
	protected static final int INCORRECT_ROOM_QP_LOSS = -2;

	/**
	 * Default Constructor
	 *
	 * @param None
	 * 				 
	 */
	public GameCard() {
	}

	/**
	 * Non-Default Constructor
	 *
	 * @param newName - Game Card name
	 * 		  imageFileName - image files name
	 * 		  validRooms - list of valid rooms to play in
	 * 				 
	 */
	public GameCard(String newName, String imageFileName, Room[] validRooms) {
		gameCardName = newName;
		gameCardImage = new ImageIcon(imageFileName);
		listOfValidRooms = new ArrayList<Room>(Arrays.asList(validRooms));
	}

	/**
	 * Returns the list of valid rooms
	 *
	 * @param None
	 * 				 
	 */
	public ArrayList<Room> getValidRooms() {
		return listOfValidRooms;
	}

	/**
	 * Returns the gameCards image 
	 *
	 * @param None
	 * 				 
	 */
	public ImageIcon getCardImage() {
		return gameCardImage;
	}

	/**
	 * Method is used to check if the player has the correct prerequisites
	 *
	 * @param player - the current player
	 * 		  learning - the learning value
	 * 		  craft - the craft value
	 * 		  integrity - the integrity value
	 * 				 
	 */
	protected boolean checkPreReqs(Player player, int learning, int craft, int integrity) {
		return (player.getLearningChips() >= learning && player.getCraftChips() >= craft
				&& player.getIntegrityChips() >= integrity);
	}

	/**
	 * Abstract method for the derived GameCards
	 *
	 * @param player - the player playing the GameCard
	 * 				 
	 */
	public abstract void play(Player player);

	
	/**
	 * Returns a string of the Game Cards Name
	 * Method used for comparing game card names
	 *
	 * @param None
	 * 				 
	 */
	public String getCardName() {
		return gameCardName;

	}

}
