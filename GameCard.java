package cecs343_bs_in_cs;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

public abstract class GameCard {

    protected String gameCardName, gameCardAction;
    private ImageIcon gameCardImage;
    protected ArrayList<Room> listOfValidRooms;
    protected int learningPreReq, craftPreReq, integrityPreReq;
    protected static final int INCORRECT_ROOM_QP_LOSS = -2;

    public GameCard() {}

    public GameCard(String newName, String imageFileName, Room[] validRooms) {
        gameCardName = newName;
        gameCardImage = new ImageIcon(imageFileName);
        listOfValidRooms = new ArrayList<Room>(Arrays.asList(validRooms));
    }

    public ArrayList<Room> getValidRooms() {
        return listOfValidRooms;
    }
            
    protected ImageIcon getCardImage() {
        System.out.println(gameCardImage);
        return gameCardImage;
    }

    protected boolean checkPreReqs(Player player, int learning,
            int craft, int integrity) {
        return (player.getLearningChips() >= learning
                && player.getCraftChips() >= craft
                && player.getIntegrityChips() >= integrity);
    }

    public abstract void play(Player player);

}
