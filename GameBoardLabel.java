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
    
    public GameBoardLabel(ImageIcon i) {
        super(i);
        image = i;
        model = new GameModel();
    }
    
    @Override
    public void paintComponent(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
    	super.paintComponent(g2);
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.PLAIN, 40));
        g2.drawString(model.getPlayer(PlayerNumber.HUMAN).getStudentName(),
                model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom().getRoomX(),
                model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom().getRoomY() +
                        model.getPlayer(PlayerNumber.HUMAN).getPlayerNumber() * 40);
        
        
        
    }
}
