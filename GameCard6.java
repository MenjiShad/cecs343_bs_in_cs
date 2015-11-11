package cecs343_bs_in_cs;

/**
 * CECS100
 * Play in ECS308
 * Get 1 Craft
 */
public class GameCard6 extends GameCard {

    public GameCard6() {}
    
    public GameCard6(String newName, String imageFileName, Room[] validRooms) {
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
        
        if (validRoom) 
            player.updateSkillChip(0, 1, 0);
        else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }

}
