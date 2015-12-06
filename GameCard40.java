package cecs343_bs_in_cs;

/**
 *    CECS 274 Play in ECS 302 or 308 or Lab
 *    Prereqs: 7 Learning
 *    Get 2 Learning Chips
 */
public class GameCard40 extends GameCard {

	public GameCard40() {
	}

	public GameCard40(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 7;
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
				player.addCardToHand(GameModel.getInstance().getCardDeck());
				gameCardAction += " for 5 Quality Points and 1 GameCard";
			} else {
				player.updateQP(-3);
				gameCardAction += " and failed";
			}
			
		}else {
				player.updateQP(INCORRECT_ROOM_QP_LOSS);
				gameCardAction += " and failed";
			}
	}

	@Override
	public String toString() {
		return gameCardAction;
	}
}
