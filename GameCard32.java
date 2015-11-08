package cecs343_bs_in_cs;

public class GameCard32 extends GameCard {

    public GameCard32() {}
    
    public GameCard32(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 0;
        craftPreReq = 0;
        integrityPreReq = 4;
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
                player.updateQP(4);
            	Object[] selectionValues = { "Learning", "Craft", "Integrity"};
            	player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
            }
            else {
            	player.discardGameCard();
            }
            
        } 
        else {
        	player.discardGameCard();
        }
        
    }
}
