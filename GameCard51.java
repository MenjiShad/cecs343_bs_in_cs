package cecs343_bs_in_cs;


/**
 * Have a Swim Play in Student Rec 
 * Prereqs: none 
 * Get A chip of choice 
 * Fail: none
 */
public class GameCard51 extends GameCard {

	public GameCard51() {
	}

	public GameCard51(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
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
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				if (player.checkIfHumanPlayer()) {
					ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, true);
					selection = ccdb.getSelection();
				} else {
					selection = player.randomChipSelection(true, true, true);
				}

				gameCardAction += " for 1 " + selection + " Chip";
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

