package cecs343_bs_in_cs;

/**
 * Score a Goal!
 * Play in George Allen Field 
 * Prereq: 3 Craft 
 * Get 5 QP and 1 Integrity 
 * Fail: Go to Student Parking
 */
public class GameCard21 extends GameCard {

    public GameCard21() {
    }

    public GameCard21(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);

        learningPreReq = 0;
        craftPreReq = 3;
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
                player.updateSkillChip(0, 0, 1);
                player.updateQP(5);
                gameCardAction += " for 5 Quality Points and 1 Integrity Chip";
            } else {
                player.setCurrentRoom(GameModel.getListOfRooms().get(2));
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
