package cecs343_bs_in_cs;

public class GameCard9 extends GameCard {

    public GameCard9() {
    }

    public GameCard9(String newName, String imageFileName, Room[] validRooms) {
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

        if (validRoom) 
            player.updateSkillChip(0, 0, 1);
        else 
            player.updateQP(incorrectRoomQPLoss);
        

    }

}
