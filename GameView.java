package cecs343_bs_in_cs;

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
<<<<<<< HEAD
public class GameView  /*implements MouseListener, Runnable */{

	// instance variables
	   private JFrame gameFrame;
	   private String frameTitle;
	   private String imageFileName;
	   private List<Room> listOfRooms = new ArrayList<Room>();
	   
=======
public class GameView /*implements MouseListener, Runnable */ {

    // instance variables
    private JFrame gameFrame;
    private String frameTitle;
    private String imageFileName;
    private GameBoardLabel gameBoardLabel;
    private JPanel masterPanel;
    private ArrayList<Room> listOfRooms;

>>>>>>> origin/master
	   //For finding the x, y of the rooms
//	   JTextArea textArea;
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
     *
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
	// The map takes 2/3 of the window height
        double heightMultiplier = (double) 2 / 3;
        double widthMultiplier = (double) 100 / 100;

        ImageIcon gameBoardImage = new ImageIcon(imageFileName);
        gameBoardLabel = new ScrollablePicture(gameBoardImage, 3);
        JPanel gameBoardPanel = new JPanel();
        masterPanel = new JPanel();
        BoxLayout masterLayout = new BoxLayout(masterPanel, BoxLayout.Y_AXIS);
        masterPanel.setLayout(masterLayout);
        JPanel controlPanel = new JPanel();

        JPanel moveButtonPanel = new JPanel();
        JButton moveButton = new JButton("Move");
        moveButton.setHorizontalTextPosition(SwingConstants.LEFT);
        moveButtonPanel.add(moveButton);

        JPanel playCardPanel = new JPanel();
        JButton playCardButton = new JButton("Play Card");
        playCardButton.setHorizontalAlignment(SwingConstants.CENTER);
        playCardPanel.add(playCardButton);

        gameBoardPanel.add(gameBoardLabel);
        controlPanel.add(moveButtonPanel);
        controlPanel.add(playCardPanel);

        // Adds scroll bars
        JScrollPane gameBoardScroller = new JScrollPane(gameBoardPanel);
        // Set the 2/3 size for the game map
        Dimension gameBoardSize = new Dimension((int) (windowWidth * widthMultiplier),
                (int) (windowHeight * heightMultiplier));
        gameBoardScroller.setPreferredSize(gameBoardSize);

        // Set the 1/3 size for the control panel
        Dimension controlPanelSize = new Dimension((int) (windowWidth * widthMultiplier),
                (int) (windowHeight * (heightMultiplier / 2)));
        controlPanel.setPreferredSize(controlPanelSize);

        masterPanel.add(gameBoardScroller);
        masterPanel.add(controlPanel);

        gameFrame.add(masterPanel);

        gameFrame.setVisible(true);

	     //For Showing the x, y location of the mouse click
//	     textArea = new JTextArea();
//	     textArea.setEditable(false);
//	     gameBoardPanel.addMouseListener(this);
<<<<<<< HEAD
       
   }
	   
   public void createRooms() {
	  	   
	   List<Integer> listOfAdjecentRooms0 = Arrays.asList(1,3,4,5);
	   List<Integer> listOfAdjecentRooms1 = Arrays.asList(0,2,3);
	   List<Integer> listOfAdjecentRooms2 = Arrays.asList(1,3,4,6);
	   List<Integer> listOfAdjecentRooms3 = Arrays.asList(0,1,2,4,5,6);
	   List<Integer> listOfAdjecentRooms4 = Arrays.asList(0,5,7,12);
	   List<Integer> listOfAdjecentRooms5 = Arrays.asList(0,2,3,4,6);
	   List<Integer> listOfAdjecentRooms6 = Arrays.asList(2,3,5,10);
	   List<Integer> listOfAdjecentRooms7 = Arrays.asList(4,8);
	   List<Integer> listOfAdjecentRooms8 = Arrays.asList(7,9);
	   List<Integer> listOfAdjecentRooms9 = Arrays.asList(8,10);
	   List<Integer> listOfAdjecentRooms10 = Arrays.asList(6,9,15);
	   List<Integer> listOfAdjecentRooms11 = Arrays.asList(12);
	   List<Integer> listOfAdjecentRooms12 = Arrays.asList(4,11,13,14,15,16);
	   List<Integer> listOfAdjecentRooms13 = Arrays.asList(12);
	   List<Integer> listOfAdjecentRooms14 = Arrays.asList(12,15);
	   List<Integer> listOfAdjecentRooms15 = Arrays.asList(10,12,14,17,18,19,20);
	   List<Integer> listOfAdjecentRooms16 = Arrays.asList(12);
	   List<Integer> listOfAdjecentRooms17 = Arrays.asList(15);
	   List<Integer> listOfAdjecentRooms18 = Arrays.asList(15);
	   List<Integer> listOfAdjecentRooms19 = Arrays.asList(15);
	   List<Integer> listOfAdjecentRooms20 = Arrays.asList(15);
	   
	   listOfRooms.add(new Room("Geroge Allen Field", 0, 271, 56, listOfAdjecentRooms0));
//	   listOfRooms.add(new Room("Japanese Garden", 1, 698, 45, listOfAdjecentRooms1));
//	   listOfRooms.add(new Room("Student Parking", 2, 1284, 94, listOfAdjecentRooms2));
//	   listOfRooms.add(new Room("The Pyramid", 3, 669, 292, listOfAdjecentRooms3));
//	   listOfRooms.add(new Room("West Walkway", 4, 246, 666, listOfAdjecentRooms4));
//	   listOfRooms.add(new Room("Health/Rec Center", 5, 708, 576, listOfAdjecentRooms5));
//	   listOfRooms.add(new Room("Forbidden Parking", 6, 1287, 586, listOfAdjecentRooms6));
//	   listOfRooms.add(new Room("Library", 7, 283, 1729, listOfAdjecentRooms7));
//	   listOfRooms.add(new Room("LA 5", 8, 712, 1638, listOfAdjecentRooms8));
//	   listOfRooms.add(new Room("Bratwurst Hall", 9, 1252, 1646, listOfAdjecentRooms9));
//	   listOfRooms.add(new Room("East Walkway", 10, 1692, 975, listOfAdjecentRooms10));
//	   listOfRooms.add(new Room("Computer Lab", 11, 422, 897, listOfAdjecentRooms11));
//	   listOfRooms.add(new Room("North Hall", 12, 427, 1164, listOfAdjecentRooms12));
//	   listOfRooms.add(new Room("Room of Retirement", 13, 437, 1367, listOfAdjecentRooms13));
//	   listOfRooms.add(new Room("ECS 302", 14, 853, 869, listOfAdjecentRooms14));
//	   listOfRooms.add(new Room("South Hall", 15, 1068, 1172, listOfAdjecentRooms15));
//	   listOfRooms.add(new Room("Elevators", 16, 829, 1385, listOfAdjecentRooms16));
//	   listOfRooms.add(new Room("ECS 308", 17, 1127, 1399, listOfAdjecentRooms17));
//	   listOfRooms.add(new Room("EAT Club", 18, 1263, 888, listOfAdjecentRooms18));
//	   listOfRooms.add(new Room("CECS Conference Room", 19, 1481, 891, listOfAdjecentRooms19));
//	   listOfRooms.add(new Room("Lactation Lounge", 20, 1447, 1410, listOfAdjecentRooms20));
	   
	   //String name = listOfRooms.get(15).getNameFromNumber();
	   

   }
   
   public void DisplayAdjecentRooms() {
	   Room currentRoom = listOfRooms.get(0);
	   
	   //Get the room number on the 1st adjecent room
	   System.out.println(listOfRooms.get(0).getListOfAdjecentRooms().get(0));
	   
	   //Create the JList here
	   
   }
   
=======
    }

    public void createRooms() {

        List<Integer> listOfAdjacentRooms0 = Arrays.asList(1, 3, 4, 5);
        List<Integer> listOfAdjacentRooms1 = Arrays.asList(0, 2, 3);
        List<Integer> listOfAdjacentRooms2 = Arrays.asList(1, 3, 4, 6);
        List<Integer> listOfAdjacentRooms3 = Arrays.asList(0, 1, 2, 4, 5, 6);
        List<Integer> listOfAdjacentRooms4 = Arrays.asList(0, 5, 7, 12);
        List<Integer> listOfAdjacentRooms5 = Arrays.asList(0, 2, 3, 4, 6);
        List<Integer> listOfAdjacentRooms6 = Arrays.asList(2, 3, 5, 10);
        List<Integer> listOfAdjacentRooms7 = Arrays.asList(4, 8);
        List<Integer> listOfAdjacentRooms8 = Arrays.asList(7, 9);
        List<Integer> listOfAdjacentRooms9 = Arrays.asList(8, 10);
        List<Integer> listOfAdjacentRooms10 = Arrays.asList(6, 9, 15);
        List<Integer> listOfAdjacentRooms11 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms12 = Arrays.asList(4, 11, 13, 14, 15, 16);
        List<Integer> listOfAdjacentRooms13 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms14 = Arrays.asList(12, 15);
        List<Integer> listOfAdjacentRooms15 = Arrays.asList(10, 12, 14, 17, 18, 19, 20);
        List<Integer> listOfAdjacentRooms16 = Arrays.asList(12);
        List<Integer> listOfAdjacentRooms17 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms18 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms19 = Arrays.asList(15);
        List<Integer> listOfAdjacentRooms20 = Arrays.asList(15);

        listOfRooms.add(new Room("Geroge Allen Field", 0, 271, 56, listOfAdjacentRooms0));
        listOfRooms.add(new Room("Japanese Garden", 1, 698, 45, listOfAdjacentRooms1));
        listOfRooms.add(new Room("Student Parking", 2, 1284, 94, listOfAdjacentRooms2));
        listOfRooms.add(new Room("The Pyramid", 3, 669, 292, listOfAdjacentRooms3));
        listOfRooms.add(new Room("West Walkway", 4, 246, 666, listOfAdjacentRooms4));
        listOfRooms.add(new Room("Health/Rec Center", 5, 708, 576, listOfAdjacentRooms5));
        listOfRooms.add(new Room("Forbidden Parking", 6, 1287, 586, listOfAdjacentRooms6));
        listOfRooms.add(new Room("Library", 7, 283, 1729, listOfAdjacentRooms7));
        listOfRooms.add(new Room("LA 5", 8, 712, 1638, listOfAdjacentRooms8));
        listOfRooms.add(new Room("Bratwurst Hall", 9, 1252, 1646, listOfAdjacentRooms9));
        listOfRooms.add(new Room("East Walkway", 10, 1692, 975, listOfAdjacentRooms10));
        listOfRooms.add(new Room("Computer Lab", 11, 422, 897, listOfAdjacentRooms11));
        listOfRooms.add(new Room("North Hall", 12, 427, 1164, listOfAdjacentRooms12));
        listOfRooms.add(new Room("Room of Retirement", 13, 437, 1367, listOfAdjacentRooms13));
        listOfRooms.add(new Room("ECS 302", 14, 853, 869, listOfAdjacentRooms14));
        listOfRooms.add(new Room("South Hall", 15, 1068, 1172, listOfAdjacentRooms15));
        listOfRooms.add(new Room("Elevators", 16, 829, 1385, listOfAdjacentRooms16));
        listOfRooms.add(new Room("ECS 308", 17, 1127, 1399, listOfAdjacentRooms17));
        listOfRooms.add(new Room("EAT Club", 18, 1263, 888, listOfAdjacentRooms18));
        listOfRooms.add(new Room("CECS Conference Room", 19, 1481, 891, listOfAdjacentRooms19));
        listOfRooms.add(new Room("Lactation Lounge", 20, 1447, 1410, listOfAdjacentRooms20));

    }

    public void updateGameBoard() {
        gameBoardLabel.repaint();
        masterPanel.repaint();
    }
>>>>>>> origin/master
//   void eventOutput(String eventDescription, MouseEvent e) {
//        System.out.println(eventDescription + " detected on "
//                + e.getComponent().getClass().getName()
//                + "." + "\n");
//        textArea.setCaretPosition(textArea.getDocument().getLength());
//    }
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//
//		System.out.println(e.getX()+ " " + e.getY());
//
//		eventOutput("Mouse pressed (# of clicks: "
//                + e.getClickCount() + ")", e);
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void run() {
//		while(true) {
//			try {
//				Thread.sleep(16);
//			}
//			catch(InterruptedException e) {
//				
//			}
//		}
//	}
}
