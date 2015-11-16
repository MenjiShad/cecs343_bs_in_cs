package cecs343_bs_in_cs;

/**
 * Professor Murgolo's CECS174 Class
 * Play in ECS302
 * Get 1 Learning
 */
public class GameCard4 extends GameCard {

    public GameCard4() {}

    public GameCard4(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
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
            player.updateSkillChip(1, 0, 0);
            gameCardAction += " for 1 Learning Chip";
        }
        else {
            player.updateQP(INCORRECT_ROOM_QP_LOSS);
            gameCardAction += " and failed";
        }
    }

    @Override
    public String toString() {
        return gameCardAction;
    }
}
