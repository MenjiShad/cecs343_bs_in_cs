package cecs343_bs_in_cs;

/**
 * Make the Dean's List 
 * Play in North or South Halls 
 * Prereq: 6 Learning 
 * Get 5 QP
 * Fail: Go to Student Parking
 */
public class GameCard23 extends GameCard {

    public GameCard23() {
    }

    public GameCard23(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 6;
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
                GameModel.getInstance().addToTotalQP(5);
                gameCardAction += " for 5 Quality Points";
            } else {
                player.setCurrentRoom(GameModel.getListOfRooms().get(2));
                gameCardAction += " and failed";
            }

        } else {
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
            GameModel.getInstance().addToTotalQP(INCORRECT_ROOM_QP_LOSS);
            gameCardAction += " and failed";
        }

    }

    @Override
    public String toString() {
        return gameCardAction;
    }
}
