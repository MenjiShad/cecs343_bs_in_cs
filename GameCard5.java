package cecs343_bs_in_cs;

/**
 * Lunch at Bratwurst Hall Play in Bratwurst Hall Get 1 Craft
 */
public class GameCard5 extends GameCard {

	public GameCard5() {
	}

	public GameCard5(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);
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
			player.updateSkillChip(0, 1, 0);
			gameCardAction += " for 1 Craft Chip";
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
