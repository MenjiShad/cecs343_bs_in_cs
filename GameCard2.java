package cecs343_bs_in_cs;

/**
 * Research Compilers
 * Play in Library
 * Get 1 Learning
 */
public class GameCard2 extends GameCard {

    public GameCard2() {}
    
    public GameCard2(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
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
        
        if (validRoom) 
            player.updateSkillChip(1, 0, 0);
        else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }

}
