package cecs343_bs_in_cs;

/**
 * Buddy Up 
 * Play in EAT Room or George Allen Field 
 * Get 1 Learning or 1 Craft
 */
public class GameCard12 extends GameCard {

    public GameCard12() {
    }

    public GameCard12(String newName, String imageFileName, Room[] validRooms) {
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

        String selection;
        if (validRoom) {
			// Add choosing dialog box if human
<<<<<<< HEAD
            // Else, AI random selects
            if (player.checkIfHumanPlayer()) {
                ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, false);
                selection = ccdb.getSelection();
            } else {
                selection = player.randomChipSelection(true, true, false);
            }

            gameCardAction += " for 1 " + selection + " Chip";
        } else {
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
            gameCardAction += " and failed";
        }

    }

    @Override
    public String toString() {
        return gameCardAction;
    }
=======
			// Else, AI random selects
			if (player.checkIfHumanPlayer()) {
				ChipChoosingDialogBox ccdb = new ChipChoosingDialogBox(true, true, false);
				selection = ccdb.getSelection();
			} else {
				selection = player.randomChipSelection(true, true, false);
			}

			gameCardAction += " for 1 " + selection + " Chip";
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
>>>>>>> origin/master
}
