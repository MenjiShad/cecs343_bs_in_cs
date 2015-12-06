package cecs343_bs_in_cs;


/**
 * CECS 282 Play in any room in ECS 
 * Prereqs: 8 Learning, 8 craft, 8 integrity 
 * Get 5 QP  Fail: Loose 2 QP and  a GameCard
 */
public class GameCard45 extends GameCard {

	public GameCard45() {
	}

	public GameCard45(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 6;
		craftPreReq = 6;
		integrityPreReq = 6;
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
				player.updateQP(-2);
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
