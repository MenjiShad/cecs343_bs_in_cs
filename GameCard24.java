package cecs343_bs_in_cs;

/**
 * A New Laptop Play in Computer Lab Prereq: 4 Integrity Get 3 QP and a chip of
 * choice Fail: Discard 1 Card
 */
public class GameCard24 extends GameCard {

	public GameCard24() {
	}

	public GameCard24(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 0;
		integrityPreReq = 4;
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
				player.updateQP(3);

				// Add choosing dialog box if human
				// Else, AI random selects
				if (player.checkIfHumanPlayer()) {
					ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, true);
					selection = ccdb.getSelection();
				} else {
					selection = player.randomChipSelection(true, true, true);
				}

				gameCardAction += " for 3 Quality Points and 1 " + selection + " Chip";

			} else {
				new CardChoosingDialogBox(player);
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
