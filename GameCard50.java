package cecs343_bs_in_cs;


/**
 * Car Pool Play in either parking lot
 * Prereqs: 5 Integrity 
 * Get 3 QP and 1 GameCard  
 * Fail: Loose 2 quality points
 */
public class GameCard50 extends GameCard {

	public GameCard50() {
	}

	public GameCard50(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 0;
		integrityPreReq = 5;
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

		if (validRoom) {
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				player.updateQP(3);
				new CardChoosingDialogBox(player);
				gameCardAction += " for 3 Quality Points and 1 GameCard";
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

