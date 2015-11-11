package cecs343_bs_in_cs;

/**
 * Learning Linux
 * Play in Computer Lab
 * Prereq: 2 Craft and Integrity
 * Get 3 QP and chip of choice
 * Fail: Lose 1 QP
 */
public class GameCard36 extends GameCard {

    public GameCard36() {}
    
    public GameCard36(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 0;
        craftPreReq = 2;
        integrityPreReq = 3;
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
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
                player.updateQP(3);
                Object[] selectionValues = { "Learning", "Craft", "Integrity"};
        	player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
            }
            else 
                player.updateQP(-1);
            
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }
}
