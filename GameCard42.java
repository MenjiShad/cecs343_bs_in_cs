package cecs343_bs_in_cs;

/**
 * CECS 201 Play in ECS 308  Prereqs: 5 Learning Get
 * 5 QP  Fail: Loose 3 quality points and a gamecard
 */
public class GameCard42 extends GameCard {

	public GameCard42() {
	}

	public GameCard42(String newName, String imageFileName, Room[] validRooms) {
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

		if (validRoom) {
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				player.updateQP(5);
				GameModel.getInstance().addToTotalQP(5);
				gameCardAction += " for 5 Quality Points";
			} else {
				player.updateQP(-3);
				GameModel.getInstance().addToTotalQP(-3);
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