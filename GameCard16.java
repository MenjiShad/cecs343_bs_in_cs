package cecs343_bs_in_cs;

public class GameCard16 extends GameCard {

    public GameCard16() {}
    
    public GameCard16(String newName, String imageFileName, Room[] validRooms) {
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
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq))
                player.updateSkillChip(0, 2, 0);
            else {
                player.updateQP(incorrectRoomQPLoss);
                player.setCurrentRoom(model.getListOfRooms().get(13));
            }
            
        } else 
             player.updateQP(incorrectRoomQPLoss);
        
    }

}
