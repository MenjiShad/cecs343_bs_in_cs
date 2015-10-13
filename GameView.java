//package cecs343_bs_in_cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;


/**
 * Author: James Dinh
 * 
 * This class is responsible for the display of the game board
 */
public class GameView  implements MouseListener, Runnable{

	// instance variables
	   private JFrame gameFrame;
	   private String frameTitle;
	   private String imageFileName;
	   private ArrayList<Room> listOfRooms;
	   
	   //For finding the x, y of the rooms
	   JTextArea textArea;
	   
	   // default constructor
	   public GameView() {
		   
		   
	      
	   }
	   
	   // constructor that takes in the title of the frame and the 
	   // file name of the board image
	   public GameView(String title, String imageFileName) {
	      frameTitle = title;
	      this.imageFileName = imageFileName;
	   }
	   
	   /** 
	    * Method to create the frame and display the board
	    * @param - None
	    * @return - void
	    */
	   public void createGameBoard() {
	     gameFrame = new JFrame(frameTitle);
	     gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	     gameFrame.setVisible(true); // Allows getSize to work correctly
	     Dimension windowSize = gameFrame.getSize();
	     int windowHeight = windowSize.height; // Save height of the window
	     int windowWidth = windowSize.width;
	     // The map takes 2/3 of the window height*
	     // windowMultiplier makes it look cleaner* 
	     // *needs to be tested
	     double heightMultiplier = (double) 2 / 3;
	     double windowMultiplier = (double) 99 / 100;
	     
	     ImageIcon image = new ImageIcon(imageFileName);
	     JLabel imageLabel = new JLabel(image);
	     JPanel gameBoardPanel = new JPanel();
	     JPanel masterPanel = new JPanel(new GridLayout(2, 0));
	     BoxLayout layout = new BoxLayout(masterPanel, BoxLayout.Y_AXIS);
	     masterPanel.setLayout(layout);
	     JPanel controlPanel = new JPanel(new CardLayout());
	     JPanel moveButton  = new JPanel();

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
	     
	     JButton move = new JButton("Move");
	     move.setHorizontalTextPosition(SwingConstants.LEFT);  
	     controlPanel.add(moveButton);
	     moveButton.add(move);
	     
	     gameFrame.setVisible(true);
	     
	     //For Showing the x, y location of the mouse click
	     textArea = new JTextArea();
	     textArea.setEditable(false);
	     
	     
	     
	     gameBoardPanel.addMouseListener(this);
       
   }
	   
   public void createRooms() {
	   
	   ArrayList<Integer> a0 = new ArrayList<Integer>();
	   a0.add(1);
	   a0.add(3);
	   a0.add(4);
	   a0.add(5);
	   
	   ArrayList<Integer> a1 = new ArrayList<Integer>();
	   
	   listOfRooms.add(new Room("Geroge Allen Field", 0, 271, 56));
	   listOfRooms.add(new Room("Japanese Garden", 1, 698, 45));
	   listOfRooms.add(new Room("Student Parking", 2, 1284, 94));
	   listOfRooms.add(new Room("The Pyramid", 3, 669, 292));
	   listOfRooms.add(new Room("West Walkway", 4, 246, 666));
	   listOfRooms.add(new Room("Health/Rec Center", 5, 708, 576));
	   listOfRooms.add(new Room("Forbidden Parking", 6, 1287, 586));
	   listOfRooms.add(new Room("Library", 7, 283, 1729));
	   listOfRooms.add(new Room("LA 5", 8, 712, 1638));
	   listOfRooms.add(new Room("Bratwurst Hall", 9, 1252, 1646));
	   listOfRooms.add(new Room("East Walkway", 10, 1692, 975));
	   listOfRooms.add(new Room("Computer Lab", 11, 422, 897));
	   listOfRooms.add(new Room("North Hall", 12, 427, 1164));
	   listOfRooms.add(new Room("Room of Retirement", 13, 437, 1367));
	   listOfRooms.add(new Room("ECS 302", 14, 853, 869));
	   listOfRooms.add(new Room("South Hall", 15, 1068, 1172));
	   listOfRooms.add(new Room("Elevators", 16, 829, 1385));
	   listOfRooms.add(new Room("ECS 308", 17, 1127, 1399));
	   listOfRooms.add(new Room("EAT Club", 18, 1263, 888));
	   listOfRooms.add(new Room("CECS Conference Room", 19, 1481, 891));
	   listOfRooms.add(new Room("Lactation Lounge", 20, 1447, 1410));
   }
   
	   
   public void DisplayPlayers(Graphics g) {
	   
	   int x = listOfRooms.get(0).xPosition;
	   int y = listOfRooms.get(0).yPosition;
	   
	   //drawString("Zach Berg", x, y);
   }
   
   
   
   void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + "." + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		System.out.println(e.getX()+ " " + e.getY());

		eventOutput("Mouse pressed (# of clicks: "
                + e.getClickCount() + ")", e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(16);
			}
			catch(InterruptedException e) {
				
			}
		}
	}
}