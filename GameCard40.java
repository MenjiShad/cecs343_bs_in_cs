package cecs343_bs_in_cs;

public class GameCard40 extends GameCard {

	public GameCard40() {
	}

	public GameCard40(String newName, String imageFileName, Room[] validRooms) {
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

		if (validRoom) {
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				gameCardAction += " for <reward>";
			} else {
				player.updateQP(INCORRECT_ROOM_QP_LOSS);
				gameCardAction += " and failed";
			}

		}
	}

	@Override
	public String toString() {
		return gameCardAction;
	}
}
