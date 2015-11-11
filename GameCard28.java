package cecs343_bs_in_cs;

/**
 * Professor Englert
 * Play in CECS Conference
 * Prereq: 3 Integrity
 * Get chip of choice
 * Fail: Discard 1 Card
 */
public class GameCard28 extends GameCard {

    public GameCard28() {}

    public GameCard28(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 0;
        craftPreReq = 0;
        integrityPreReq = 3;
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
                Object[] selectionValues = {"Learning", "Craft", "Integrity"};
                player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
            } else 
                player.discardGameCard();
            

        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
    
    }
}
