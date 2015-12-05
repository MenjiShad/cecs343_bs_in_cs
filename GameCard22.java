package cecs343_bs_in_cs;

/**
 * Fall in the Pond 
 * Play in Japanese Garden 
 * Prereq: 3 Learning 
 * Get 1 Integrity and Craft 
 * Fail: Go to Lactaction Lounge
 */
public class GameCard22 extends GameCard {

    public GameCard22() {
    }

    public GameCard22(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
        learningPreReq = 3;
        craftPreReq = 0;
        integrityPreReq = 0;
    }

    @Override
    public void play(Player player) {
        // Check for correct Room
        boolean validRoom = false;
        for (Room room : listOfValidRooms) {
            // Prep Current Play String
            gameCardAction = player.getStudentName() + " played " + gameCardName;
            // Check if the player is in one of the valid Rooms
            if (player.getCurrentRoom().equals(room)) {
                validRoom = true;
                break;
            }
        }

        if (validRoom) {
            // Check prereqs
            if (checkPreReqs(player, learningPreReq, craftPreReq, integrityPreReq)) {
                player.updateSkillChip(0, 1, 1);
                gameCardAction += " for 1 Craft and 1 Integrity Chip";
            } else {
                player.setCurrentRoom(GameModel.getListOfRooms().get(20));
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
