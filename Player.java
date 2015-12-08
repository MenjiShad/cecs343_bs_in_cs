package cecs343_bs_in_cs;

import java.util.ArrayList;
/**
 * Author: James Dinh and Zachary Berg
 *
 * This class is responsible for representing the players
 */
public class Player {

	private String name;
	private int playerNumber;
	private Room currentRoom;
	private int qualityPoint;
	private int learningChip;
	private int integrityChip;
	private int craftChip;
	private ArrayList<GameCard> handOfCards;

	/**
	 * Non-Default Constructor 
	 * 	initializes players
	 *
	 * @param name - name of the player
	 * 		  playerNumber - players number
	 * 		  startingRoom - the staring room of the player
	 * 		  initialLearning - initial value of learning
	 * 		  initialIntegrity - initial value of integrity
	 * 		  initialCraft - intital value of craft
	 * 				 
	 */
	public Player(String name, int playerNumber, Room startingRoom, int initialLearning, int initialIntegrity,
			int initialCraft) {
		this.name = name;
		this.playerNumber = playerNumber;
		currentRoom = startingRoom;
		learningChip = initialLearning;
		integrityChip = initialIntegrity;
		craftChip = initialCraft;
		handOfCards = new ArrayList<>();

	}

	/**
	 * Returns the string of the students name
	 *
	 * @param None
	 * 				 
	 */
	public String getStudentName() {
		return name;
	}

	/**
	 * Method to set the current room
	 *
	 * @param newRoom
	 * 				 - the room to set
	 * 				 
	 */
	public void setCurrentRoom(Room newRoom) {
		currentRoom = newRoom;
	}

	/**
	 * Returns the Room that the current player is in
	 *
	 * @param None
	 * 				 
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Returns the players number
	 *
	 * @param None
	 * 				 
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * Returns the players learning value
	 *
	 * @param None
	 * 				 
	 */
	public int getLearningChips() {
		return learningChip;
	}
	
	/**
	 * Returns the players integrity value
	 *
	 * @param None
	 * 				 
	 */
	public int getIntegrityChips() {
		return integrityChip;
	}

	/**
	 * Returns the players craft value
	 *
	 * @param None
	 * 				 
	 */
	public int getCraftChips() {
		return craftChip;
	}

	/**
	 * Returns the players quality points
	 *
	 * @param None
	 * 				 
	 */
	public int getQualityPoints() {
		return qualityPoint;
	}

	/**
	 * Method to update the players quality points
	 *
	 * @param pointUpdate - the qp value to add or subtract
	 * 				 
	 */
	public void updateQP(int pointUpdate) {
		qualityPoint += pointUpdate;
		checkQPForSkillChip();
		GameModel.getInstance().addToTotalQP(pointUpdate);
	}
	
	/**
	 * Method to check if the players qp is divisble by 15
	 * 	if it is, reward a skill chip of choice
	 *
	 * @param None
	 * 				 
	 */
	public void checkQPForSkillChip() {
		if(qualityPoint % 15 == 0 && qualityPoint > 0) {
			
			//Creates a dialog box for selecting a chip
			
			if(checkIfHumanPlayer()) {
                            ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, true);
				ccdb.getSelection();
			}
			else {
                            randomChipSelection(true, true, true);
			}
		}
	
	}

	/**
	 * Updates the players skill chip
	 *
	 * @param learningUpdate - value to update learning
	 * 		  craftUpdate - value to update craft
	 * 		  integrityUpdate - value to update integrity
	 * 				 
	 */
	public void updateSkillChip(int learningUpdate, int craftUpdate, int integrityUpdate) {
		learningChip += learningUpdate;
		craftChip += craftUpdate;
		integrityChip += integrityUpdate;
	}

	/**
	 * Method to play a GameCard
	 *
	 * @param card - the GameCard to play
	 * 				 
	 */
	public void playCard(GameCard card) {
		discardGameCard(card);
		card.play(this);
	}
	
	/**
	 * Method to remove the players hand
	 *
	 * @param None
	 * 
	 */
	public void removeHand() {
		System.out.println("Clearing Hand");
		handOfCards.clear();
	}

	/**
	 * Discard a GameCard that has been played
	 *
	 * @param card
	 *            - GameCard to be discarded
	 */
	public void discardGameCard(GameCard card) {
		GameModel.getInstance().getCardDeck().addToDiscard(card);
		getHandOfCards().remove(card);
	}

	/**
	 * Adds a GameCard to players hand
	 *
	 * @param cardDeck
	 * 				  - deck of cards
	 * 				 
	 */
	public void addCardToHand(Deck cardDeck) {
		handOfCards.add(cardDeck.drawCard());
	}

	/**
	 * Returns the players hand of cards
	 *
	 * @param None
	 * 				 
	 */
	public ArrayList<GameCard> getHandOfCards() {
		return handOfCards;
	}

	/**
	 * Checks to see if the player is human
	 *
	 * @param None
	 * 
	 */
	public boolean checkIfHumanPlayer() {
		if (name.equals(GameModel.getInstance().getPlayer(PlayerNumber.HUMAN).getStudentName())) {
			return true;
		}
		return false;
	}

	/**
	 * Randomly chooses a chip 
	 * 	used for AI players
	 *
	 * @param learningEnable - boolean value to update learning
	 * 		  craftEnable - boolean value to update craft
	 * 		  integrityEnable - boolean value to update integrity
	 * 				 
	 */
	public String randomChipSelection(boolean learningEnable, boolean craftEnable, boolean integrityEnable) {
		int i = 0;
		if (learningEnable) {
			i++;
		}
		if (craftEnable) {
			i++;
		}
		if (integrityEnable) {
			i++;
		}

		String[] chips = new String[i];
		if (learningEnable) {
			chips[--i] = "Learning";
		}

		if (craftEnable) {
			chips[--i] = "Craft";
		}

		if (integrityEnable) {
			chips[--i] = "Integrity";
		}

		String selection = chips[(int) (Math.pow(this.hashCode(), chips.length) % chips.length)];

		if (selection.equals("Learning")) {
			this.updateSkillChip(1, 0, 0);
		}

		if (selection.equals("Craft")) {
			this.updateSkillChip(0, 1, 0);
		}

		if (selection.equals("Integrity")) {
			this.updateSkillChip(0, 0, 1);
		}

		return selection;
	}
	
	/**
	 * Returns a string telling which room the player is in
	 *
	 * @param None
	 * 				 
	 */
	@Override
	public String toString() {
		return "\n" + name + " is in " + currentRoom;
	}
}
