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
    private JTextArea informationTextArea = new JTextArea(10,110);
    private GameCard currentViewedCard;

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
        
        JPanel cycleCardPanel = new JPanel();
        JButton cycleCardButton = new JButton("Cycle Card");
        cycleCardButton.setHorizontalAlignment(SwingConstants.CENTER);
        cycleCardPanel.add(cycleCardButton);
        cycleCardButton.setEnabled(true);
        
   
    
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
        
      //Cycle cards to choose from
        //Still have to figure out how to delete card from screen if the player plays the card
        final class CycleCardActionListener implements ActionListener {
        	private int counter = 1;
        	
        	CycleCardActionListener(){ 
        		gameCardLabel = new JLabel("", model.getPlayer(PlayerNumber.HUMAN)
        	            		.getHandOfCards().get(0).getCardImage(), JLabel.CENTER);
        		currentViewedCard = model.getPlayer(PlayerNumber.HUMAN)
		        		.getHandOfCards().get(0);
        	}

			@Override
			public void actionPerformed(ActionEvent e) {
				//If its the last card in the hand, show the first card
				if(counter == model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().size()) {

					gameCardLabel.setIcon( model.getPlayer(PlayerNumber.HUMAN)
			        		.getHandOfCards().get(0).getCardImage());
					currentViewedCard = model.getPlayer(PlayerNumber.HUMAN)
			        		.getHandOfCards().get(0);
					gameCardLabel.setHorizontalAlignment(JLabel.CENTER);
					counter = 1;
					System.out.println();

				}
				else {
					gameCardLabel.setIcon( model.getPlayer(PlayerNumber.HUMAN)
			        		.getHandOfCards().get(counter).getCardImage());
					currentViewedCard = model.getPlayer(PlayerNumber.HUMAN)
			        		.getHandOfCards().get(counter);
					gameCardLabel.setHorizontalAlignment(JLabel.CENTER);
					counter++;
				}
				 
				
			}

        	
        }
        cycleCardButton.addActionListener(new CycleCardActionListener());
        cycleCardPanel.add(cycleCardButton);

        // Play Card action listener
        final class PlayCardActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Figure out how to pass GameCard value into here
            	
            	//Debug
            	System.out.println(currentViewedCard);
            	
            	//Still have to figure out how to discard the card on the screen before the player is allowed to play the card again
            	
                model.getPlayer(PlayerNumber.HUMAN).playCard(currentViewedCard);
                playCardButton.setEnabled(false);
                drawCardButton.setEnabled(true);
                model.getPlayer(PlayerNumber.HUMAN).discardGameCard();
                updateGameBoard();
            }      
        }
        playCardButton.addActionListener(new PlayCardActionListener());
        playCardPanel.add(playCardButton);
        
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
        
        //Create layout for the cycle button panel
        BoxLayout gameCardPanelLayout = new BoxLayout(gameCardPanel, BoxLayout.Y_AXIS);
        gameCardPanel.setLayout(gameCardPanelLayout);

        //Add panels to list and button panel
        listAndButtonPanel.add(drawCardButtonPanel);
        listAndButtonPanel.add(moveButtonPanel);
        listAndButtonPanel.add(playCardPanel);
        
        gameCardPanel.setPreferredSize(new Dimension(
                (int) (controlPanelSize.width * controlPanelWidthMultipler),
                controlPanelSize.height));
        
                
        
        gameCardPanel.add(gameCardLabel);
        gameCardPanel.add(cycleCardPanel);

        // Figure out how to expand both text areas into better sizes
        informationTextArea.append("\tLearning\tCraft\tIntegrity\tQuality Points"
        												+ "\n" + model.getPlayer(PlayerNumber.HUMAN).getStudentName() + "\t " + model.getPlayer(PlayerNumber.HUMAN).getLearningChips() + "\t "
        												+ model.getPlayer(PlayerNumber.HUMAN).getCraftChips() + "\t "
        												+ model.getPlayer(PlayerNumber.HUMAN).getIntegrityChips() + "\t "
        												+ model.getPlayer(PlayerNumber.HUMAN).getQualityPoints()
        												+ "\n" + model.getPlayer(PlayerNumber.AI1).getStudentName() + "\t " + model.getPlayer(PlayerNumber.AI1).getLearningChips() + "\t "
        												+ model.getPlayer(PlayerNumber.AI1).getCraftChips() + "\t "
        												+ model.getPlayer(PlayerNumber.AI1).getIntegrityChips() + "\t "
        												+ model.getPlayer(PlayerNumber.AI1).getQualityPoints()
        												+ "\n" + model.getPlayer(PlayerNumber.AI2).getStudentName() + "\t " + model.getPlayer(PlayerNumber.AI2).getLearningChips() + "\t "
        												+ model.getPlayer(PlayerNumber.AI2).getCraftChips() + "\t "
        												+ model.getPlayer(PlayerNumber.AI2).getIntegrityChips() + "\t "
        												+ model.getPlayer(PlayerNumber.AI2).getQualityPoints()
        												+ "\n\n" 
        												+ "Cards in Deck:  " + model.getCardDeck().getListOfCards().size()
        												+ "\tDiscards out of play:  " + model.getCardDeck().getListOfDiscardedCards().size()
        												+ "\n\nYou are " + model.getPlayer(PlayerNumber.HUMAN).getStudentName() 
        												+ " and you are in room " + model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom());
        JTextArea currentPlayTextArea = new JTextArea("Current Play Panel", 5, 110);
        
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


    public void DisplayInformationPanel() {
    	
    }

    public void updateGameBoard() {
        //Create rooms and displays them on the list
        DisplayAdjacentRooms();
        gameBoardLabel.paintComponent(gameBoardLabel.getGraphics());
        
        //Have to figure out how to not reuse this code...
        informationTextArea.setText("\tLearning\tCraft\tIntegrity\tQuality Points"
				+ "\n" + model.getPlayer(PlayerNumber.HUMAN).getStudentName() + "\t " + model.getPlayer(PlayerNumber.HUMAN).getLearningChips() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getCraftChips() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getIntegrityChips() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getQualityPoints()
				+ "\n" + model.getPlayer(PlayerNumber.AI1).getStudentName() + "\t " + model.getPlayer(PlayerNumber.AI1).getLearningChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getCraftChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getIntegrityChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getQualityPoints()
				+ "\n" + model.getPlayer(PlayerNumber.AI2).getStudentName() + "\t " + model.getPlayer(PlayerNumber.AI2).getLearningChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getCraftChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getIntegrityChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getQualityPoints()
				+ "\n\n" 
				+ "Cards in Deck:  " + model.getCardDeck().getListOfCards().size()
				+ "\tDiscards out of play:  " + model.getCardDeck().getListOfDiscardedCards().size()
				+ "\n\nYou are " + model.getPlayer(PlayerNumber.HUMAN).getStudentName() 
				+ " and you are in room " + model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom());
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
