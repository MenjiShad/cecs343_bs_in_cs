package cecs343_bs_in_cs;

public class GameCard10 extends GameCard {

    public GameCard10() {}
    
    public GameCard10(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 6;
        craftPreReq = 6;
        integrityPreReq = 6;
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
                player.updateQP(10);
            else {
                // Discard one Card
            }
        } else 
            player.updateQP(incorrectRoomQPLoss);
        
    }

}
