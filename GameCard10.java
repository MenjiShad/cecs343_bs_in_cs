package cecs343_bs_in_cs;

/**
 * Goodbye Professor
 * Play in Room of Retirement
 * Prereqs: 6 Learning, 6 Craft, 6 Integrity
 * Get 10 QP
 * Fail: Lose 1 Game Card and leave in RoR
 */
public class GameCard10 extends GameCard {

    public GameCard10() {}
    
    public GameCard10(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 6;
        craftPreReq = 6;
        integrityPreReq = 6;
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
                player.updateQP(10);
            gameCardAction += " for 10 Quality Points";
            }
            else {
                // Discard one Card
            	new CardChoosingDialogBox(player);
            	
            	//Need to figure out how to delete card from deck 
            	
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
