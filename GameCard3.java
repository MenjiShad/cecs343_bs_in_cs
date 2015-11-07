package cecs343_bs_in_cs;

public class GameCard3 extends GameCard {

    public GameCard3() {}
    
    public GameCard3(String newName, String imageFileName, Room[] validRooms) {
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
            // Check prereqs
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
               // Player chooses between 1 learning or integrity
            }
            else 
                player.updateQP(incorrectRoomQPLoss);
            
        } else 
             player.updateQP(incorrectRoomQPLoss);
        
    }

}
