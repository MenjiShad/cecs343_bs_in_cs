package cecs343_bs_in_cs;

/**
 * Late for Class
 * Play in any space outside except Forbidden Parking
 * Get 1 Craft and teleport to Lactation Lounge
 */
public class GameCard13 extends GameCard {

    public GameCard13() {}
    
    public GameCard13(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
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
            player.updateSkillChip(0, 1, 0);
            player.setCurrentRoom(model.getListOfRooms().get(20));       
        } else 
             player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }

}
