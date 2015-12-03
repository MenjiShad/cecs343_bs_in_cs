package cecs343_bs_in_cs;

/**
 * KIN253 Learning the Rules of Soccer Play in George Allen Field Prereq: 4
 * Integrity Get 2 Craft Fail: Go to Room of Retirement
 */
public class GameCard16 extends GameCard {

	public GameCard16() {
	}

	public GameCard16(String newName, String imageFileName, Room[] validRooms) {
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

		if (validRoom) {
			// Check prereqs
			if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
				player.updateSkillChip(0, 2, 0);
				gameCardAction += " for 2 Craft Chips";
			} else {
				player.setCurrentRoom(GameModel.getListOfRooms().get(13));
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
