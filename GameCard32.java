package cecs343_bs_in_cs;

/**
 * Oral Communication
 * Play in any building not ECS
 * Prereq: 4 Integrity
 * Get 4 QP and a chip of choice
 * Fail: Discard 1 Card
 */
public class GameCard32 extends GameCard {

    public GameCard32() {}
    
    public GameCard32(String newName, String imageFileName, Room[] validRooms) {
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
                player.updateQP(4);
            	Object[] selectionValues = { "Learning", "Craft", "Integrity"};
            	player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
                gameCardAction += " for 4 Quality Points and 1 <chip> Chip";
            }
            else {
            	player.chooseCardToDiscard();
                gameCardAction += " and failed";
            }
       
        } 
        else {
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
            gameCardAction += " and failed";
        }
    
    }

    @Override
    public String toString() {
        return gameCardAction;
    }
}
