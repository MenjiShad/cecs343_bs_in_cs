package cecs343_bs_in_cs;

/**
 * MATH122 
 * Play in Library 
 * Get 1 Learning or Integrity
 */
public class GameCard3 extends GameCard {

    public GameCard3() {
    }

    public GameCard3(String newName, String imageFileName, Room[] validRooms) {
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
            // Player chooses between 1 learning or integrity
            gameCardAction += " for 1 <chip> Chip";
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
