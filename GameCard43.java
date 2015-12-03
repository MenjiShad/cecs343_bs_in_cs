package cecs343_bs_in_cs;

/**
 * CECS 228 Play in Computer Lab Prereqs: 5 Learning, 3 Craft Get
 * 5 QP  Fail: Go to student parking
 */
public class GameCard43 extends GameCard {

	public GameCard43() {
	}

	public GameCard43(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 3;
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

		if (validRoom) {
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				player.updateQP(5);
				gameCardAction += " for 5 Quality Points";
			} else {
				player.setCurrentRoom(GameModel.getListOfRooms().get(2));
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

