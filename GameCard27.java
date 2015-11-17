package cecs343_bs_in_cs;

/**
 * Program Crashes
 * Play in Lactation Lounge
 * Prereq: 2 Learning
 * Get 5 QP and chip of choice
 * Fail: Discard 1 Card
 */
public class GameCard27 extends GameCard {

    public GameCard27() {
    }

    public GameCard27(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 2;
        craftPreReq = 0;
        integrityPreReq = 0;
    }

    @Override
    public void play(Player player) {
        // Prep Current Play String
        gameCardAction = player.getStudentName() + " played " + gameCardName;
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
                gameCardAction += " for 5 Quality Points and 1 <chip> Chip";
            } else {
                player.chooseCardToDiscard();
                gameCardAction += " and failed";
            }

        } else {
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
            gameCardAction += " and failed";
        }

    }

    @Override
    public String toString() {
        return gameCardAction;
    }
}
