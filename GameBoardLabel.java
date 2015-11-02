package cecs343_bs_in_cs;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author James
 */
public class GameBoardLabel extends JLabel {

    // instance variables
    private ImageIcon image;
    private static GameModel model;

    // default constructor
    public GameBoardLabel() {
        image = null;
    }

    public GameBoardLabel(ImageIcon i, GameModel model) {
        super(i);
        image = i;
        this.model = model;
    }

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
