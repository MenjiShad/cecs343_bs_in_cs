package cecs343_bs_in_cs;

/**
 * Loud Buzzing
 * Play in EAT Room
 * Prereq: 3 Craft
 * Get 1 Chip of choice
 * Fail: Lose 2 QP
 */
public class GameCard26 extends GameCard {

    public GameCard26() {}

    public GameCard26(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 0;
        craftPreReq = 3;
        integrityPreReq = 0;
    }

    @Override
    public void play(Player player) {
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
                //get 1 chip of choice
            }
            else
                player.updateQP(-2);
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        

    }
}
