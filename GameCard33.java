package cecs343_bs_in_cs;

/**
 * Professor Hoffman Play in any room in ECS except Lactation Lounge Prereq: 3
 * Learning Get 5 QP and 2 Cards Fail: Lose 5 QP and go to Lactation Lounge
 */
public class GameCard33 extends GameCard {

	public GameCard33() {
	}

	public GameCard33(String newName, String imageFileName, Room[] validRooms) {
		super(newName, imageFileName, validRooms);

		learningPreReq = 3;
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
				player.addCardToHand(GameModel.getInstance().getCardDeck());
				player.addCardToHand(GameModel.getInstance().getCardDeck());
				gameCardAction += " for 5 Quality Points and 2 cards";
			} else {
				player.updateQP(-5);
				GameModel.getInstance().addToTotalQP(-5);
				player.setCurrentRoom(GameModel.getListOfRooms().get(20));
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
