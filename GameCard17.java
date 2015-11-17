package cecs343_bs_in_cs;

/**
 * MATH123
 * Play in ECS302 or 308
 * Prereq: 5 Learning
 * Get 5 QP
 * Fail: Lose 3 QP and 1 Game Card
 */
public class GameCard17 extends GameCard {

    public GameCard17() {}
    
    public GameCard17(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 5;
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
                gameCardAction += " for 5 Quality Points";
            }
            else {
                player.updateQP(-3);
                player.chooseCardToDiscard();
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
