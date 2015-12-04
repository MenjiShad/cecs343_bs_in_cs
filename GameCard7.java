package cecs343_bs_in_cs;

/**
 * Exercising Body and Mind Play in Student Recreation Get 1 Integrity
 */
public class GameCard7 extends GameCard {

	public GameCard7() {
	}

	public GameCard7(String newName, String imageFileName, Room[] validRooms) {
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
			player.updateSkillChip(0, 0, 1);
			gameCardAction += " for 1 Integrity Chip";
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
