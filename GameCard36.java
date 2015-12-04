package cecs343_bs_in_cs;

/**
 * Learning Linux Play in Computer Lab Prereq: 2 Craft and Integrity Get 3 QP
 * and chip of choice Fail: Lose 1 QP
 */
public class GameCard36 extends GameCard {

	public GameCard36() {
	}

	public GameCard36(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 2;
		integrityPreReq = 3;
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
				GameModel.getInstance().addToTotalQP(3);
				if (player.checkIfHumanPlayer()) {
					ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, true);
					selection = ccdb.getSelection();
				} else {
					selection = player.randomChipSelection(true, true, true);
				}
				gameCardAction += " for 3 Quality Points and 1 " + selection + " Chip";
			} else {
				player.updateQP(-1);
				GameModel.getInstance().addToTotalQP(-1);
				gameCardAction += " and failed";
			}

		} else {
			player.updateQP(INCORRECT_ROOM_QP_LOSS);
			GameModel.getInstance().addToTotalQP(INCORRECT_ROOM_QP_LOSS);
			gameCardAction += " and failed";
		}

	}

	@Override
	public String toString() {
		return gameCardAction;
	}
}
