package cecs343_bs_in_cs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

/**
 * Author: James Dinh and Zachary Berg
 *
 * This class is responsible for the display of the game board
 */
public class GameView {

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
	private JTextArea informationTextArea;
	private JTextArea currentPlayTextArea;
	private GameCard currentViewedCard;
	private boolean playedCard;
	private boolean changedDeck = false;

	/**
	 * Default Constructor
	 *
	 * @param None
	 * 				 
	 */
	public GameView() {
		moveCount = 0;
		playedCard = false;
	}

	/**
	 * Non-Default Constructor
	 *
	 * @param title - the frame title of the GameBoard
	 * 		  imageFileName - the file name of the GameBoard picture
	 * 		  model - the Game's Model
	 * 				 
	 */
	public GameView(String title, String imageFileName, GameModel model) {
		frameTitle = title;
		this.imageFileName = imageFileName;
		GameView.model = model;
	}

	/**
	 * Method to create the frame and display all components
	 */
	public void createGameFrame() {
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

		// Creates the play card and move button
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

				System.out.println("Drawing 1 card to hand");
				model.getPlayer(PlayerNumber.HUMAN).addCardToHand(model.getCardDeck());
				currentViewedCard = model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0);
				drawCardButton.setEnabled(false);
				moveButton.setEnabled(true);
				playCardButton.setEnabled(true);
				moveCount = 0;
				updateGameBoard();
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
				moveCount++;

				// Only allows the player to move up to 3 times
				// Might need to implement this differently
				if (moveCount >= 3) {
					moveButton.setEnabled(false);
				}

			}
		}
		moveButton.addActionListener(new MoveActionListener());
		moveButtonPanel.add(moveButton);

		gameCardLabel = new JLabel("", model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0).getCardImage(),
				JLabel.CENTER);
		
		// Cycle cards to choose from and show them on the GameBoard
		final class CycleCardActionListener implements MouseListener {

			private int counter = 1;

			CycleCardActionListener() {

				currentViewedCard = model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				gameCardLabel.setIcon(model.getPlayer(PlayerNumber.HUMAN).getHandOfCards()
						.get(counter % (model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().size())).getCardImage());
				currentViewedCard = model.getPlayer(PlayerNumber.HUMAN).getHandOfCards()
						.get(counter % (model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().size()));
				System.out.println("Currently Viewed Card: " + currentViewedCard.getCardName());
				counter++;

			}
			
			//Methods not used 
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

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

		}
		gameCardLabel.addMouseListener(new CycleCardActionListener());
		// cycleCardPanel.add(cycleCardButton);

		// Play Card action listener
		final class PlayCardActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Playing Card: " + currentViewedCard.getCardName());
				model.getPlayer(PlayerNumber.HUMAN).playCard(currentViewedCard);
				updateCurrentPlay(currentViewedCard);
				playCardButton.setEnabled(false);
				moveButton.setEnabled(false);
				drawCardButton.setEnabled(true);

				// Updates the current card viewed
				playedCard = true;
				if (playedCard) {
					gameCardLabel.setIcon(model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0).getCardImage());
					currentViewedCard = model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0);
				}
				playedCard = false;
				updateTurn();
				updateGameBoard();
				
				// If the totalQP reaches 60, change the deck to year 2
				if(model.getTotalQP() >= 60 && !changedDeck) {
					System.out.println("Canging deck");
					model.setNewCards();
					changedDeck = true;
					currentPlayTextArea.append("\nChangingDeck");
					updateGameBoard();
					gameCardLabel.setIcon(model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0).getCardImage());
					currentViewedCard = model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().get(0);
				}
			
			}
		}
		playCardButton.addActionListener(new PlayCardActionListener());
		playCardPanel.add(playCardButton);

		// Create layout for the control panel
		BoxLayout controlPanelLayout = new BoxLayout(controlPanel, BoxLayout.X_AXIS);
		controlPanel.setLayout(controlPanelLayout);

		// Control panel components
		double controlPanelWidthMultipler = (double) 1 / 6;

		// Create layout for the list and buttons panel and set prefered size
		BoxLayout listAndButtonPanelLayout = new BoxLayout(listAndButtonPanel, BoxLayout.Y_AXIS);
		listAndButtonPanel.setLayout(listAndButtonPanelLayout);
		listAndButtonPanel.setPreferredSize(
				new Dimension((int) (controlPanelSize.width * controlPanelWidthMultipler), controlPanelSize.height));
		
		// Create size of the game card panel
		gameCardPanel.setPreferredSize(
				new Dimension((int) (controlPanelSize.width * controlPanelWidthMultipler), controlPanelSize.height));

		gameCardPanel.add(gameCardLabel);

		informationTextArea = new JTextArea("Information Panel", 15, 115);
		currentPlayTextArea = new JTextArea(
				"Human player is " + model.getPlayer(PlayerNumber.HUMAN).getStudentName() + "\n", 7, 113);
		JScrollPane currentPlayTextAreaSP = new JScrollPane(currentPlayTextArea); 
		// JTextArea is placed in a JScrollPane.
		Border blackline = BorderFactory.createLineBorder(Color.black);

		// Info Panel GUI
		JPanel informationPanel = new JPanel();
		informationPanel.setBorder(blackline);
		informationPanel.add(informationTextArea);
		informationPanel.setPreferredSize(new Dimension((int) (controlPanelSize.width * controlPanelWidthMultipler * 4),
				(int) (controlPanelSize.height * ((double) 2 / 3))));

		// Current Play Text Area GUI
		JPanel currentPlayPanel = new JPanel();
		currentPlayPanel.setBorder(blackline);
		currentPlayPanel.add(currentPlayTextAreaSP);
		currentPlayPanel.setPreferredSize(new Dimension(
				(int) (controlPanelSize.width * (controlPanelWidthMultipler * 2)), controlPanelSize.height));
		JScrollPane currentPlayScroller = new JScrollPane(currentPlayPanel);
		currentPlayPanel
				.setPreferredSize(new Dimension((int) (controlPanelSize.width * (controlPanelWidthMultipler * 2)),
						(int) (controlPanelSize.height * ((double) 1 / 3))));

		BoxLayout textAreaPanelLayout = new BoxLayout(textAreaPanel, BoxLayout.Y_AXIS);
		textAreaPanel.setLayout(textAreaPanelLayout);
		textAreaPanel.add(informationPanel);
		textAreaPanel.add(currentPlayScroller);

		adjacentRoomsList = new JList<Room>();
		DisplayAdjacentRooms();

		updateInformationPanel();

		// Add panels to list and button panel
		listAndButtonPanel.add(drawCardButtonPanel);
		listAndButtonPanel.add(moveButtonPanel);
		listAndButtonPanel.add(playCardPanel);
		listScroller = new JScrollPane(adjacentRoomsList);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listAndButtonPanel.add(listScroller);

		// Add panels to control panel
		controlPanel.add(listAndButtonPanel);
		controlPanel.add(gameCardPanel);
		controlPanel.add(textAreaPanel);

		masterPanel.add(gameBoardScroller);
		masterPanel.add(controlPanel);
		gameFrame.add(masterPanel);
		gameFrame.setVisible(true);
	}

	/**
	 * Displays Adjecent Rooms for the human players current room
	 *
	 * @param None
	 * 				 
	 */
	public void DisplayAdjacentRooms() {

		// Create the JList here
		DefaultListModel<Room> listModel = new DefaultListModel<>();

		// Stores Adjacent Rooms into a list model for JList
		for (int i = 0; i < model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom().getListOfAdjacentRooms().size(); i++) {

			int adjacentRoomNumber = model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom().getListOfAdjacentRooms()
					.get(i);
			listModel.addElement(GameModel.getListOfRooms().get(adjacentRoomNumber));
		}

		// Create JList of adjacent Rooms
		// Use ListCellRenderer to display the room name
		adjacentRoomsList.setModel(listModel);
		adjacentRoomsList.setCellRenderer(new AdjacentRoomsListRenderer());

		adjacentRoomsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adjacentRoomsList.setVisibleRowCount(3);
	}

	/**
	 * Updates the information panel 
	 *
	 * @param None
	 * 				 
	 */
	public void updateInformationPanel() {
		informationTextArea.setText("\tLearning\tCraft\tIntegrity\tQuality Points" + "\n"
				+ model.getPlayer(PlayerNumber.HUMAN).getStudentName() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getLearningChips() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getCraftChips() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getIntegrityChips() + "\t "
				+ model.getPlayer(PlayerNumber.HUMAN).getQualityPoints() + "\n"
				+ model.getPlayer(PlayerNumber.AI1).getStudentName() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getLearningChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getCraftChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getIntegrityChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI1).getQualityPoints() + "\n"
				+ model.getPlayer(PlayerNumber.AI2).getStudentName() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getLearningChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getCraftChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getIntegrityChips() + "\t "
				+ model.getPlayer(PlayerNumber.AI2).getQualityPoints() + "\n\n" + "Cards in Deck:  "
				+ model.getCardDeck().getListOfCards().size() + "\tDiscards out of play:  "
				+ model.getCardDeck().getListOfDiscardedCards().size() + "\tCards in hand:  " 
				+ model.getPlayer(PlayerNumber.HUMAN).getHandOfCards().size() + "\t Total QP: "
				+ model.getTotalQP() + "\n\nYou are "
				+ model.getPlayer(PlayerNumber.HUMAN).getStudentName() + " and you are in room "
				+ model.getPlayer(PlayerNumber.HUMAN).getCurrentRoom() + "\n"
				+ model.getPlayer(PlayerNumber.AI1).getStudentName() + " is in room "
				+ model.getPlayer(PlayerNumber.AI1).getCurrentRoom() + "\n"
				+ model.getPlayer(PlayerNumber.AI2).getStudentName() + " is in room "
				+ model.getPlayer(PlayerNumber.AI2).getCurrentRoom());
	}

	/**
	 * Updates the current play
	 *
	 * @param card
	 * 			  -players GameCard
	 * 				 
	 */
	public void updateCurrentPlay(GameCard card) {
		currentPlayTextArea.append("\n" + card.toString());
	}

	/**
	 * Method used to control the turn-taking
	 *
	 * @param None
	 * 				 
	 */
	public void updateTurn() {

		// Reset move counter
		moveCount = 0;

		// AI Move and Play
		// Make sure the AI doesn't try to draw from an empty Deck
		checkDeckEmpty();
		updateCurrentPlay(model.AITurn(model.getPlayer(PlayerNumber.AI1)));
		checkDeckEmpty();
		updateCurrentPlay(model.AITurn(model.getPlayer(PlayerNumber.AI2)));
		checkDeckEmpty();
	}

	/**
	 * Method used to check if the Deck is empty
	 *
	 * @param None
	 * 				 
	 */
	private void checkDeckEmpty() {
		// Shuffle discarded deck and add them to active deck
		if (model.getCardDeck().getListOfCards().isEmpty()) {
			model.getCardDeck().shuffleDiscardDeck();
		}
	}

	/**
	 * Method used to update the GameBoard
	 *
	 * @param None
	 * 				 
	 */
	public void updateGameBoard() {
		// Create rooms and displays them on the list
		DisplayAdjacentRooms();
		gameBoardLabel.repaint();
		updateInformationPanel();
	}
}
