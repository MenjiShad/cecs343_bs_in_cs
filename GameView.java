package cecs343_bs_in_cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Author: James Dinh and Zachary Berg
 *
 * This class is responsible for the display of the game board
 */
public class GameView  /*implements MouseListener*/ {

    // instance variables
    private JFrame gameFrame;
    private String frameTitle;
    private String imageFileName;
    private GameBoardLabel gameBoardLabel;
    private JLabel gameCardLabel;
    private JPanel masterPanel;
    private JPanel gameBoardPanel = new JPanel();
    private JPanel controlPanel = new JPanel();
    private JPanel listAndButtonPanel = new JPanel();
    private JPanel gameCardPanel = new JPanel();
    private JPanel textAreaPanel = new JPanel();
    private static GameModel model;
    private JList<Room> adjacentRoomsList;
    private JScrollPane listScroller;
    private int moveCount;

    //For finding the x, y of the rooms
//	   JTextArea textArea;
	   
    // default constructor
    public GameView() {}

    // constructor that takes in the title of the frame and the 
    // file name of the board image
    public GameView(String title, String imageFileName, GameModel model) {
        frameTitle = title;
        this.imageFileName = imageFileName;
        this.model = model;
    }

    /**
     * Method to create the frame and display the board
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
        gameBoardLabel = new ScrollablePicture(gameBoardImage, 3, model);
        masterPanel = new JPanel();
        BoxLayout masterLayout = new BoxLayout(masterPanel, BoxLayout.Y_AXIS);
        masterPanel.setLayout(masterLayout);

        gameBoardPanel.add(gameBoardLabel);

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

        // Create Draw Card button
        JPanel drawCardButtonPanel = new JPanel();
        JButton drawCardButton = new JButton("Draw Card");
        drawCardButton.setHorizontalTextPosition(SwingConstants.CENTER);
        drawCardButton.setEnabled(true);
        
        //Creates the play card and move button
        JPanel moveButtonPanel = new JPanel();
        JButton moveButton = new JButton("Move");
        moveButton.setHorizontalTextPosition(SwingConstants.LEFT);
        moveButton.setEnabled(false);
        
        JPanel playCardPanel = new JPanel();
        JButton playCardButton = new JButton("Play Card");
        playCardButton.setHorizontalAlignment(SwingConstants.CENTER);
        playCardPanel.add(playCardButton);
        playCardButton.setEnabled(false);
        
        // Draw Card Action Listener
        final class DrawCardActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getPlayer(PlayerNumber.HUMAN).addCardToHand(model.getCardDeck());
                drawCardButton.setEnabled(false);
                moveButton.setEnabled(true);
                playCardButton.setEnabled(true);
            }
        }
        drawCardButton.addActionListener(new DrawCardActionListener());
        drawCardButtonPanel.add(drawCardButton);

        // Add action listener to move button
        final class MoveActionListener implements ActionListener {

            // Move the player from one room to another on button press
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Add handling for the case where no room is selected
                
                
                Room newRoom = adjacentRoomsList.getSelectedValue();
                model.getPlayer(PlayerNumber.HUMAN).setCurrentRoom(newRoom);
                updateGameBoard();
            }
        }
        moveButton.addActionListener(new MoveActionListener());
        moveButtonPanel.add(moveButton);

        // Play Card action listener
        final class PlayCardActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Figure out how to pass GameCard value into here
                model.getPlayer(PlayerNumber.HUMAN).playCard(null);
            }      
        }
        
        //Create layout for the control panel
        BoxLayout controlPanelLayout = new BoxLayout(controlPanel, BoxLayout.X_AXIS);
        controlPanel.setLayout(controlPanelLayout);

        //For Showing the x, y location of the mouse click
//	     textArea = new JTextArea();
//	     textArea.setEditable(false);
//	     gameBoardPanel.addMouseListener(this);
        
        // Control panel components
        double controlPanelWidthMultipler = (double) 1 / 6;
        
        //Create layout for the list and buttons panel and set prefered size
        BoxLayout listAndButtonPanelLayout = new BoxLayout(listAndButtonPanel, BoxLayout.Y_AXIS);
        listAndButtonPanel.setLayout(listAndButtonPanelLayout);
        listAndButtonPanel.setPreferredSize(new Dimension((int)
                (controlPanelSize.width * controlPanelWidthMultipler),
                controlPanelSize.height));

        //Add panels to list and button panel
        listAndButtonPanel.add(drawCardButtonPanel);
        listAndButtonPanel.add(moveButtonPanel);
        listAndButtonPanel.add(playCardPanel);
        
        gameCardPanel.setPreferredSize(new Dimension(
                (int) (controlPanelSize.width * controlPanelWidthMultipler),
                controlPanelSize.height));
        gameCardLabel = new JLabel("", model.getPlayer(PlayerNumber.HUMAN)
        		.getHandOfCards().get(0).getCardImage(), JLabel.CENTER);
        gameCardPanel.add(gameCardLabel);

        // Figure out how to expand both text areas into better sizes
	JTextArea informationTextArea = new JTextArea("Information Panel");
        JTextArea currentPlayTextArea = new JTextArea("Current Play Panel");
        
        JPanel informationPanel = new JPanel();
        informationPanel.add(informationTextArea);
        informationPanel.setPreferredSize(new Dimension((int)
                (controlPanelSize.width * controlPanelWidthMultipler * 4),
                controlPanelSize.height));
        
        JPanel currentPlayPanel = new JPanel();
        currentPlayPanel.add(currentPlayTextArea);
        currentPlayPanel.setPreferredSize(new Dimension((int)
                (controlPanelSize.width * (controlPanelWidthMultipler * 2)),
                controlPanelSize.height));
        
        BoxLayout textAreaPanelLayout = new BoxLayout(textAreaPanel, BoxLayout.Y_AXIS);
        textAreaPanel.setLayout(textAreaPanelLayout);
        textAreaPanel.add(informationPanel);
        textAreaPanel.add(currentPlayPanel);
        
        adjacentRoomsList = new JList<Room>();
        DisplayAdjacentRooms();
        
        listScroller = new JScrollPane(adjacentRoomsList);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listAndButtonPanel.add(listScroller);
        
        //Add panels to control panel
        controlPanel.add(listAndButtonPanel);
        controlPanel.add(gameCardPanel);
        controlPanel.add(textAreaPanel);
        
        masterPanel.add(gameBoardScroller);
        masterPanel.add(controlPanel);
        gameFrame.add(masterPanel);
        gameFrame.setVisible(true);
        
    }

    public void DisplayAdjacentRooms() {

        //Create the JList here
        DefaultListModel<Room> listModel = new DefaultListModel<>();
        
        //Stores Adjacent Rooms into a list model for JList
        for (int i = 0; i < model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom()
                .getListOfAdjacentRooms().size(); i++) {

            int adjacentRoomNumber = model.getPlayer(PlayerNumber.HUMAN).
            getCurrentRoom().getListOfAdjacentRooms().get(i);
            listModel.addElement(model.getListOfRooms().get(adjacentRoomNumber));
        }
        
        // Create JList of adjacent Rooms
        // Use ListCellRenderer to display the room name
        adjacentRoomsList.setModel(listModel);
        adjacentRoomsList.setCellRenderer(new AdjacentRoomsListRenderer());

        adjacentRoomsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        adjacentRoomsList.setVisibleRowCount(3);   
    }

    public void DisplayGameCard() {
    	
    }

    public void DisplayTextArea() {

    }

    public void updateGameBoard() {
        //Create rooms and displays them on the list
        DisplayAdjacentRooms();
        gameBoardLabel.paintComponent(gameBoardLabel.getGraphics());
    }
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
//	//@Override
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
