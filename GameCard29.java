package cecs343_bs_in_cs;

/**
 * Press the Right Floor
 * Play at Elevators
 * Prereq: 4 Learning
 * Get 2 Craft
 * Fail: Lose 2 QP
 */
public class GameCard29 extends GameCard {

    public GameCard29() {}
    
    public GameCard29(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 4;
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
            // Check prereqs
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq))
                player.updateSkillChip(0, 2, 0);
            
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }
}
