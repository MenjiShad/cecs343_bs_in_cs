package cecs343_bs_in_cs;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Buddy Up
 * Play in EAT Room or George Allen Field
 * Get 1 Learning or 1 Craft
 */
public class GameCard12 extends GameCard {

    public GameCard12() {}
    
    public GameCard12(String newName, String imageFileName, Room[] validRooms) {
        super(newName, imageFileName, validRooms);
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
            // Dialog box giving player choice of learning or integrity
            Object[] selectionValues = { "Learning", "Craft"};
            player.chooseChip(selectionValues, "Choose either 1 learning or integrity chip..."); 
        } else 
             player.updateQP(INCORRECT_ROOM_QP_LOSS);
        
    }
}
