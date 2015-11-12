package cecs343_bs_in_cs;

/**
 * Student Parking
 * Play in Student Parking
 * Get 1 Craft
 * Teleport to Lactation Lounge
 */
public class GameCard39 extends GameCard {

    public GameCard39() {}
    
    public GameCard39(String newName, String imageFileName, Room[] validRooms) {
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
        
        if (validRoom) {
                player.updateSkillChip(0, 1, 0);
//            	player.setCurrentRoom(model.getListOfRooms().get(20));
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }
}
