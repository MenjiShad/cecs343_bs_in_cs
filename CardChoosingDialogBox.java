package cecs343_bs_in_cs;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CardChoosingDialogBox extends JDialog {

    private JPanel dialogPanel;
    private JPanel masterPanel = new JPanel();
    //private JPanel dialogPanel = new JPanel();
    //private JPanel buttonPanel = new JPanel();
    private ArrayList<JLabel> images = new ArrayList<>();
    private ArrayList<JPanel> buttonPanels = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();
    private static final int DIALOG_BOX_WIDTH = 1500;
    private static final int DIALOG_BOX_HEIGHT = 400;
    private Player currentPlayer;
    //private static JOptionPane jp = new JOptionPane();

    public CardChoosingDialogBox(Player human) {
    	
    	//Checks if human player
    	if(human.checkIfHumanPlayer()) {

	        masterPanel.setSize(1500, 400);
	        this.setModalityType(DEFAULT_MODALITY_TYPE); // Set to Modal
	        this.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
	        //dialogPanel.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
	        currentPlayer = human;
	
	        //Adding cards and button images to dialogPanel
	        for (int i = 0; i < human.getHandOfCards().size(); i++) {
	            images.add(new JLabel(human.getHandOfCards().get(i).getCardImage()));
	            buttons.add(new JButton(human.getHandOfCards().get(i).getCardName()));
	            buttonPanels.add(new JPanel());
	            BoxLayout dialogLayout = new BoxLayout(buttonPanels.get(i), BoxLayout.Y_AXIS);
	            buttonPanels.get(i).setLayout(dialogLayout); // Thinking BoxLayout
	            //buttonPanels.get(i).add(Box.createHorizontalStrut(100));
	            buttonPanels.get(i).add(images.get(i));
	            buttonPanels.get(i).add(buttons.get(i));
	            masterPanel.add(buttonPanels.get(i));
	        	//dialogPanel.add(images.get(i));
	            //buttonPanel.add(buttonPanels.get(i));
	
	        }

	        final class ButtonListener implements ActionListener {
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                System.out.println("\n\n" + e.getActionCommand());
	                for (int i = 0; i < currentPlayer.getHandOfCards().size(); i++) {
	
	                    if (e.getActionCommand().equals(currentPlayer.getHandOfCards().get(i).getCardName())) {
	                        System.out.println("\n\nFound " + currentPlayer.getHandOfCards().get(i).getCardName() + "\n\n");
	                        //currentPlayer.getHandOfCards().remove(currentPlayer.getHandOfCards().get(i));
	                        currentPlayer.discardGameCard(currentPlayer.getHandOfCards().get(i));
	                        dispose();
	                    }
	                }
	
	            }
	
	        }
	
	        //Adding a listener to each GameCard Image
	        for (int i = 0; i < buttons.size(); i++) {
	            buttons.get(i).addActionListener(new ButtonListener());
	        }
	
	        this.add(masterPanel);
	        this.setVisible(true);
    	}

    }

//    public void chooseCardToDiscard() {
//        //Checks if human player
//        if (currentPlayer.checkIfHumanPlayer()) {
//
//            JDialog.setDefaultLookAndFeelDecorated(true);
//            Object[] objectCards = new Object[currentPlayer.getHandOfCards().size()];
//
//            for (int i = 0; i < currentPlayer.getHandOfCards().size(); i++) {
//                objectCards[i] = currentPlayer.getHandOfCards().get(i).getCardName();
//            }
//
//            Object selection = JOptionPane.showInputDialog(frame, "Choose a card to discard",
//                    "Choice", JOptionPane.QUESTION_MESSAGE, null, objectCards, currentPlayer.getHandOfCards().get(0));
//
//	    	//JOptionPane.showMessageDialog((Component)dialogPanel, selection, "Discard Card", JOptionPane.PLAIN_MESSAGE, currentPlayer.getHandOfCards().get(0).getCardImage());
//            //jp.add(dialogPanel);
//            System.out.println("\n\nSELECTION: " + selection + "\n\n");		//Debugging
//
//            for (int i = 0; i < currentPlayer.getHandOfCards().size(); i++) {
//
//                if (selection.equals(currentPlayer.getHandOfCards().get(i).getCardName())) {
//                    currentPlayer.getHandOfCards().remove(currentPlayer.getHandOfCards().get(i));
//                }
//            }
//            frame.setVisible(false);
//        }
//    }

}
