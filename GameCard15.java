package cecs343_bs_in_cs;

public class GameCard15 extends GameCard {

    public GameCard15() {}
    
    public GameCard15(String newName, String imageFileName, Room[] validRooms) {
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
                player.updateSkillChip(0, 1, 0);
                player.setCurrentRoom(model.getListOfRooms().get(20));
            }
            else 
                player.updateQP(incorrectRoomQPLoss);
            
        } else 
             player.updateQP(incorrectRoomQPLoss);
        
    }

}
