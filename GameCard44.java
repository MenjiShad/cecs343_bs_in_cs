package cecs343_bs_in_cs;

/**
 * CECS 285 Play in EAT Room or Japanese Garden 
 * Prereqs: 6 Learning \
 * Get 5 QP and Chip of your choice  
 * Fail: Loose 3 quality points
 */
public class GameCard44 extends GameCard {

	public GameCard44() {
	}

	public GameCard44(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 5;
		craftPreReq = 0;
		integrityPreReq = 0;
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
				player.updateQP(5);
				ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, false, true);
				selection = ccdb.getSelection();
			} else {
				selection = player.randomChipSelection(true, false, true);
			}

			gameCardAction += " for 5 Quality Points and  1 " + selection + " Chip";
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