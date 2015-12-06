package cecs343_bs_in_cs;

/**
 * Enjoying the Peace Play in Japanese Gardens Get 1 Learning or 1 Integrity
 */
public class GameCard11 extends GameCard {

	public GameCard11() {
	}

	public GameCard11(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);
	}

	@Override
	public void play(Player player) {
		// Prep Current Play String
		gameCardAction = player.getStudentName() + " played " + gameCardName;
		// Check for correct Room
		boolean validRoom = false;
		for (Room room : listOfValidRooms) {
			// Check if the player is in one of the valid Rooms
			if (player.getCurrentRoom().equals(room)) {
				validRoom = true;
				break;
			}
		}

		String selection;
		if (validRoom) {
			// Add choosing dialog box if human
			// Else, AI random selects
			if (player.checkIfHumanPlayer()) {
				ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, false, true);
				selection = ccdb.getSelection();
			} else {
				selection = player.randomChipSelection(true, false, true);
			}

			gameCardAction += " for 1 " + selection + " Chip";
		} else {
			player.updateQP(INCORRECT_ROOM_QP_LOSS);
			gameCardAction += " and failed";
		}

	}

	@Override
	public String toString() {
		return gameCardAction;
	}
}
