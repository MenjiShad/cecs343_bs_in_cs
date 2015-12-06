package cecs343_bs_in_cs;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CardChoosingDialogBox extends JDialog {

    private JPanel masterPanel = new JPanel();
    private ArrayList<JLabel> images = new ArrayList<>();
    private ArrayList<JPanel> buttonPanels = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();
    private static final int DIALOG_BOX_WIDTH = 1500;
    private static final int DIALOG_BOX_HEIGHT = 400;
    private Player currentPlayer;

    public CardChoosingDialogBox(Player human) {
    	
    	//Checks if human player
    	if(human.checkIfHumanPlayer()) {

	        masterPanel.setSize(1500, 400);
	        this.setModalityType(DEFAULT_MODALITY_TYPE); // Set to Modal
	        this.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
	        currentPlayer = human;
	
	        //Adding cards and button images to dialogPanel
	        for (int i = 0; i < human.getHandOfCards().size(); i++) {
	            images.add(new JLabel(human.getHandOfCards().get(i).getCardImage()));
	            buttons.add(new JButton(human.getHandOfCards().get(i).getCardName()));
	            buttonPanels.add(new JPanel());
	            BoxLayout dialogLayout = new BoxLayout(buttonPanels.get(i), BoxLayout.Y_AXIS);
	            buttonPanels.get(i).setLayout(dialogLayout); // Thinking BoxLayout
	            buttonPanels.get(i).add(images.get(i));
	            buttonPanels.get(i).add(buttons.get(i));
	            masterPanel.add(buttonPanels.get(i));
	
	        }

	        final class ButtonListener implements ActionListener {
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               
	                for (int i = 0; i < currentPlayer.getHandOfCards().size(); i++) {
	
	                    if (e.getActionCommand().equals(currentPlayer.getHandOfCards().get(i).getCardName())) {
	                    	System.out.println("Player " + currentPlayer + " discarded " + currentPlayer.getHandOfCards().get(i).getCardName());
	                        currentPlayer.discardGameCard(currentPlayer.getHandOfCards().get(i));
	                        dispose();
	                        break;
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

}
