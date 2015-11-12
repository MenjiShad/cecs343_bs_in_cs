package cecs343_bs_in_cs;

/**
 * Meet the Dean
 * Play in North of South Hall
 * Prereq: 3 Learning, 3 Craft, 3
 * Integrity 
 * Get 5 QP and 1 Card 
 * Fail: Discard 1 Card
 */
public class GameCard25 extends GameCard {

    public GameCard25() {}

    public GameCard25(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 3;
        craftPreReq = 3;
        integrityPreReq = 3;
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
                player.updateQP(5);
                Object[] selectionValues = {"Learning", "Craft", "Integrity"};
                player.chooseChip(selectionValues, "Choose a quality chip of your choice...");
            } else 
                player.discardGameCard();
            
        } else 
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
    }
}
