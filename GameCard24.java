package cecs343_bs_in_cs;

/**
 * A New Laptop
 * Play in Computer Lab
 * Prereq: 4 Integrity
 * Get 3 QP and a chip of choice
 * Fail: Discard 1 Card
 */
public class GameCard24 extends GameCard {

    public GameCard24() {}

    public GameCard24(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 0;
        craftPreReq = 0;
        integrityPreReq = 4;
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
                player.updateQP(3);

                //choose a quality chip of your choice
                Object[] selectionValues = {"Learning", "Craft", "Integrity"};
                player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
            } else 
                player.discardGameCard();
            

        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
        

    }
}
