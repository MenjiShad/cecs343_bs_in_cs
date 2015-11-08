package cecs343_bs_in_cs;

public class GameCard23 extends GameCard {

    public GameCard23() {}
    
    public GameCard23(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 6;
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
            	player.setCurrentRoom(model.getListOfRooms().get(2));
            }
            
        } else{
        	player.setCurrentRoom(model.getListOfRooms().get(2));
        	}
    }
}
