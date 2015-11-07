package cecs343_bs_in_cs;

public class GameCard17 extends GameCard {

    public GameCard17() {}
    
    public GameCard17(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 5;
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
            // Check prereqs
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq))
                player.updateQP(5);
            else {
                player.updateQP(-3);
                // Lose 1 GameCard
            }
            
        } else 
             player.updateQP(incorrectRoomQPLoss);
        
    }

}
