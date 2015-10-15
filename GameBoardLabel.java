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
//        Graphics2D g2 = (Graphics2D) g;

        super.paintComponents(g);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Matt", 100, 700);
        
    }
}
