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
    
    // default constructor
    public GameBoardLabel() {
        image = null;
    }
    
    public GameBoardLabel(ImageIcon i) {
        super(i);
        image = i;
    }
    
    @Override
    public void paintComponents(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
    	super.paintComponent(g2);
        g2.setColor(Color.BLUE);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        //g.drawString("Matt", 100, 700);
        g2.drawString("Matt", 1127, 1399);
        
        
        
    }
}
