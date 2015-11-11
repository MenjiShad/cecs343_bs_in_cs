package cecs343_bs_in_cs;

/**
 * CHEM111
 * Play in any building not ECS
 * Prereq: 6 Craft
 * Get 5 QP
 * Fail: Go to Student Parking
 */
public class GameCard34 extends GameCard {

    public GameCard34() {}
    
    public GameCard34(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 0;
        craftPreReq = 6;
        integrityPreReq = 0;
    }
        
    @Override
    public void play(Player player, GameModel model) {
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
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq))
                player.updateQP(5);
            else {
            	player.setCurrentRoom(model.getListOfRooms().get(2));
            }
            
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
           
    }
}
