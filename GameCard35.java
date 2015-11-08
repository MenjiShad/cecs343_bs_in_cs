package cecs343_bs_in_cs;

public class GameCard35 extends GameCard {

    public GameCard35() {}
    
    public GameCard35(String newName, String imageFileName, Room[] validRooms) {
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
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)){
            	Object[] selectionValues = { "Learning", "Craft", "Integrity"};
            	player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
            }
            else {
            	//do nothing
            }
            
        } else {
        	//do nothing
        }
        
    }
}
