package cecs343_bs_in_cs;

public class GameCard8 extends GameCard {

    public GameCard8() {}
    
    public GameCard8(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 0;
        craftPreReq = 0;
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
            player.updateSkillChip(1, 0, 0);
            // Prompt user to discard one card for 1 additional learning chip
        } else 
             player.updateQP(incorrectRoomQPLoss);
        
    }

}
