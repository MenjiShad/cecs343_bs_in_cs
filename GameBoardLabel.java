//package cecs343_bs_in_cs;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author James
 */
public class GameBoardLabel extends JLabel {
    
    // instance variables
    private ImageIcon image;
    private String name;
    private int xLocation;
    private int yLocation;
    
    // default constructor
    public GameBoardLabel() {
        image = null;
    }
    
    public GameBoardLabel(ImageIcon i) {
        super(i);
        image = i;
    }
    
    @Override
    public void paintComponent(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
    	super.paintComponent(g2);
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.PLAIN, 40));
        g2.drawString(name, xLocation, yLocation);
        
        
        
    }
}
