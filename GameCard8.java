package cecs343_bs_in_cs;

/**
 * Parking Violation
 * Play in Forbidden Parking
 * Get 1 Learning (May discard 1 Card for another Learning)
 */
public class GameCard8 extends GameCard {

    public GameCard8() {}
    
    public GameCard8(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 0;
        craftPreReq = 0;
        integrityPreReq = 0;
    }
        
    @Override
    public void play(Player player) {
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
            player.updateSkillChip(2, 0, 0);
            
            // Prompt user to discard one card for 1 additional learning chip
            //player.discardGameCard();
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }

}
