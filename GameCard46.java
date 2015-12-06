package cecs343_bs_in_cs;


/**
 * PHIL 270 Play in LA 5 or Library 
 * Prereqs: 7 Integrity 
 * Get 3 QP and 1 Learning Chip  
 * Fail: Loose 3 QP
 */
public class GameCard46 extends GameCard {

	public GameCard46() {
	}

	public GameCard46(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 0;
		craftPreReq = 0;
		integrityPreReq = 7;
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
				player.updateSkillChip(1, 0, 0);
				gameCardAction += " for 3 Quality Points and 1 Learning Chip";
			} else {
				player.updateQP(-3);
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
