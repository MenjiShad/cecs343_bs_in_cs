package cecs343_bs_in_cs;

/**
 * Elective Class
 * Play in Library 
 * Prereq: 2 
 * Get 1 Learning and 1 Card
 * Fail: Lose 2 QP
 */
public class GameCard31 extends GameCard {

    public GameCard31() {
    }

    public GameCard31(String newName, String imageFileName, Room[] validRooms) {
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
                player.updateSkillChip(1, 0, 0);
//                player.addCardToHand();
                gameCardAction += " for 1 Learning Chip and 1 card";
            } 
            else {
                player.updateQP(-2);
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
