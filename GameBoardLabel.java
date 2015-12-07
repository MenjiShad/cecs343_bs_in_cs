package cecs343_bs_in_cs;

import javax.swing.*;
import java.awt.*;

/**
 * Author: James Dinh and Zachary Berg
 *
 * This class is responsible for the display of the players on the Game Board
 */
public class GameBoardLabel extends JLabel {

	// instance variables
	private static final long serialVersionUID = 1L;
    private ImageIcon image;
    private static GameModel model;

    /**
	 * Default Constructor
	 *
	 * @param None
	 * 				 
	 */
    public GameBoardLabel() {
        setImage(null);
    }
    
    /**
	 * Non-Default Constructor
	 * Creates a Game Board
	 *
	 * @param listOfRooms
	 * 					 - a list of all the Rooms 
	 * 				 
	 */
    public GameBoardLabel(ImageIcon i, GameModel model) {
        super(i);
        setImage(i);
        GameBoardLabel.model = model;
    }

    /**
   	 * Gets the Image of the Game Board
   	 *
   	 * @param None
   	 * 				 
   	 */
	public ImageIcon getImage() {
		return image;
	}

	 /**
	 * Sets the image of the Game Board
	 *
	 * @param image
	 * 				- Game Board Image
	 * 				 
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	 /**
	 * This method paints the players name on the Game Board
	 *
	 * @param g
	 * 			- graphics component
	 * 				 
	 */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.PLAIN, 40));

        // Draw the position of the human player
        g2.drawString(model.getPlayer(PlayerNumber.HUMAN).getStudentName(),
                model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom().getRoomX(),
                model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom().getRoomY()
                + model.getPlayer(PlayerNumber.HUMAN).getPlayerNumber() * 40);

        // Draw position of AI Player 1
        g2.drawString(model.getPlayer(PlayerNumber.AI1).getStudentName(),
                model.getPlayer(PlayerNumber.AI1).getCurrentRoom().getRoomX(),
                model.getPlayer(PlayerNumber.AI1).getCurrentRoom().getRoomY()
                + model.getPlayer(PlayerNumber.AI1).getPlayerNumber() * 40);
        
        // Draw position of AI Player 2
        g2.drawString(model.getPlayer(PlayerNumber.AI2).getStudentName(),
                model.getPlayer(PlayerNumber.AI2).getCurrentRoom().getRoomX(),
                model.getPlayer(PlayerNumber.AI2).getCurrentRoom().getRoomY()
                + model.getPlayer(PlayerNumber.AI2).getPlayerNumber() * 40);
    }
}
