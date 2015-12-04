package cecs343_bs_in_cs;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Player {

	private String name;
	private int playerNumber;
	private Room currentRoom;
	private int qualityPoint;
	private int learningChip;
	private int integrityChip;
	private int craftChip;
	private ArrayList<GameCard> handOfCards;

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

	public String getStudentName() {
		return name;
	}

	@Override
	public String toString() {
		return "\n" + name + " is in " + currentRoom;
	}

	public void setCurrentRoom(Room newRoom) {
		currentRoom = newRoom;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public int getLearningChips() {
		return learningChip;
	}

	public int getCraftChips() {
		return craftChip;
	}

	public int getIntegrityChips() {
		return integrityChip;
	}

	public int getQualityPoints() {
		return qualityPoint;
	}

	public void updateQP(int pointUpdate) {
		qualityPoint += pointUpdate;
	}

	// Think about passing in String gameCardAction and then
	// using this method to modify it?
	public void updateSkillChip(int learningUpdate, int craftUpdate, int integrityUpdate) {
		learningChip += learningUpdate;
		craftChip += craftUpdate;
		integrityChip += integrityUpdate;
	}

	public void playCard(GameCard card) {
		discardGameCard(card);
		card.play(this);
	}
	
	public void removeHand() {
		System.out.println("Clearing Hand");
		handOfCards.clear();
	}

	// public void discardGameCard() {
	// //Open dialog box to allow player to discard
	// }
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

	
	public void addCardToHand(Deck cardDeck) {
		handOfCards.add(cardDeck.drawCard());
	}

	public ArrayList<GameCard> getHandOfCards() {
		return handOfCards;
	}

	/**
	 * Checks to see if the player is human
	 *
	 * @param
	 */
	public boolean checkIfHumanPlayer() {
		if (name.equals(GameModel.getInstance().getPlayer(PlayerNumber.HUMAN).getStudentName())) {
			return true;
		}
		return false;
	}

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
}
