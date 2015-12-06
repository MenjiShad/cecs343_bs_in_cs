package cecs343_bs_in_cs;

/**
 * CECS 201 Play in ECS 302 or 308 or lab
 * Prereqs: 8 Craft 
 * Get 1 learning, 1 craft, 1 integrity
 *  Fail: Loose 3 quality points, discard game card
 */
public class GameCard41 extends GameCard {

	public GameCard41() {
	}

	public GameCard41(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 8;
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
				player.updateSkillChip(1, 1, 1);
				gameCardAction += " for 1 Lerning, 1 Craft, and 1 Integrity";
			} else {
				player.updateQP(-3);
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
