package cecs343_bs_in_cs;


/**
 * Pay Tuition Play in Bratwurst Hall Prereqs: none Get
 * 1 learning chip and discard 1 card for another learning chip Fail: none
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

		if (validRoom) {
			player.updateSkillChip(2, 0, 0);
			gameCardAction += " for 1 Learning Chip and discarded 1 GameCard for 1 Learning Chip";
			// Prompt user to discard one card for 1 additional learning chip
			new CardChoosingDialogBox(player);

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

