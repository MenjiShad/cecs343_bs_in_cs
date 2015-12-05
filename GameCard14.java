package cecs343_bs_in_cs;

/**
 * Physics 151
 * Play in ECS 308 
 * Prereq: 3 Craft
 * Get 5 QP
 * Fail: Lose 3 QP
 */
public class GameCard14 extends GameCard {

    public GameCard14() {
    }

    public GameCard14(String newName, String imageFileName, Room[] validRooms) {
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
            // Prep Current Play String
            gameCardAction = player.getStudentName() + " played " + gameCardName;
            // Check prereqs
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
                player.updateQP(5);
                gameCardAction += " for 5 Quality Points";
            } else {
                player.updateQP(-3);
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
