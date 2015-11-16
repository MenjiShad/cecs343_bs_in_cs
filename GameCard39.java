package cecs343_bs_in_cs;

/**
 * Student Parking 
 * Play in Student Parking
 * Get 1 Craft and teleport to Lactation Lounge
 */
public class GameCard39 extends GameCard {

    public GameCard39() {
    }

    public GameCard39(String newName, String imageFileName, Room[] validRooms) {
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
            player.updateSkillChip(0, 1, 0);
            player.setCurrentRoom(GameModel.getListOfRooms().get(20));
            gameCardAction += " for 1 Craft Chip and teleported to Lactation"
                    + " Lounge";
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
