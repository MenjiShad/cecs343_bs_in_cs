package cecs343_bs_in_cs;

public class GameCard21 extends GameCard {

    public GameCard21() {}
    
    public GameCard21(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        
        learningPreReq = 0;
        craftPreReq = 3;
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
    			player.updateSkillChip(0, 0, 1);
    			player.updateQP(5);
    		}
    		else {
    			player.setCurrentRoom(model.getListOfRooms().get(2));
    		}
        
    	} else  {
    		player.setCurrentRoom(model.getListOfRooms().get(2));
    	}
    
	}

}
