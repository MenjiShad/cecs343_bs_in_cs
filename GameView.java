package cecs343_bs_in_cs;

import javax.swing.*;
import java.awt.*;

/**
 * Author: James Dinh
 *
 * This class is responsible for the display of the game board
 */
public class GameView {

    // instance variables
    private JFrame gameFrame;
    private String frameTitle;
    private String imageFileName;
    private int windowHeight;
    private int windowWidth;
    
    // The map takes 2/3 of the window height*
    // windowMultiplier makes it look cleaner* 
    // *needs to be tested
    private static final double heightMultiplier = (double) 2 / 3;
    private static final double windowMultiplier = (double) 99 / 100;

    // default constructor
    public GameView() {

    }

    // constructor that takes in the title of the frame and the 
    // file name of the board image and initializes the frame
    public GameView(String title, String imageFileName) {
        frameTitle = title;
        this.imageFileName = imageFileName;
        gameFrame = new JFrame(frameTitle);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gameFrame.setVisible(true); // Allows getSize to work correctly
        Dimension windowSize = gameFrame.getSize();
        windowHeight = windowSize.height; // Save height of the window
        windowWidth = windowSize.width;
    }

    /**
     * Method to draw the components on the frame
     * Components include the game board and the controller
     */
    public void drawGameBoard() {


        // Set up the game map, the map's panel, and the controller panel
        ImageIcon image = new ImageIcon(imageFileName);
        JLabel imageLabel = new JLabel(image);
        JPanel gameBoardPanel = new JPanel();
        JPanel masterPanel = new JPanel();
        BoxLayout layout = new BoxLayout(masterPanel, BoxLayout.Y_AXIS);
        masterPanel.setLayout(layout);
        JPanel controlPanel = new JPanel(new CardLayout());

        gameBoardPanel.add(imageLabel);
        // Adds scroll bars
        JScrollPane gameBoardScroller = new JScrollPane(gameBoardPanel);
        
        // Set the 2/3 size for the game map
        Dimension gameBoardSize = new 
            Dimension((int) (windowWidth * windowMultiplier),
                (int) (windowHeight * heightMultiplier));
        gameBoardScroller.setPreferredSize(gameBoardSize);
        
        // Set the 1/3 size for the control panel
        Dimension controlPanelSize = new 
            Dimension((int) (windowWidth * windowMultiplier),
                (int) (windowHeight * (heightMultiplier / 2)));
        controlPanel.setPreferredSize(controlPanelSize);
        
        masterPanel.add(gameBoardScroller);
        masterPanel.add(controlPanel);

        gameFrame.add(masterPanel);
        gameFrame.setVisible(true);
    }
    
    /**
     * Method to draw the player tokens onto the Board
     */
    public void drawToken() {
        
    }
}
