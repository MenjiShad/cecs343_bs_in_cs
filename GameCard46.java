package cecs343_bs_in_cs;


/**
 * PHIL 270 Play in any building not ECS Prereqs: 6 Craft Get
 * 4 QP and chip of choice  Fail: Discard 1 gamecard
 */
public class GameCard46 extends GameCard {

	public GameCard46() {
	}

	public GameCard46(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 6;
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
				player.updateQP(4);
				GameModel.getInstance().addToTotalQP(4);
				if (player.checkIfHumanPlayer()) {
					ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, true);
					selection = ccdb.getSelection();
				} else {
					selection = player.randomChipSelection(true, true, true);
				}
				gameCardAction += " for 4 Quality Points and 1 " + selection + " Chip";
			} else {
				new CardChoosingDialogBox(player);
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
