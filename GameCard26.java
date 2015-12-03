package cecs343_bs_in_cs;

/**
 * Loud Buzzing Play in EAT Room Prereq: 3 Craft Get 1 Chip of choice Fail: Lose
 * 2 QP
 */
public class GameCard26 extends GameCard {

	public GameCard26() {
	}

	public GameCard26(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 3;
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
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				// Add choosing dialog box if human
				// Else, AI random selects
				if (player.checkIfHumanPlayer()) {
					ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, true);
					selection = ccdb.getSelection();
				} else {
					selection = player.randomChipSelection(true, true, true);
				}

				gameCardAction += " for 1 " + selection + " Chip";
			} else {
				player.updateQP(-2);
				gameCardAction += " and failed";
			}
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
