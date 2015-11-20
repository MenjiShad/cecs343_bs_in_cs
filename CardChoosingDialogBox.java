package cecs343_bs_in_cs;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CardChoosingDialogBox extends JDialog{
	
	private JFrame frame = new JFrame("Dialog Box");
	private JPanel dialogPanel = new JPanel();
	private ArrayList<JLabel> images = new ArrayList<>();
    private static final int DIALOG_BOX_WIDTH = 800;
    private static final int DIALOG_BOX_HEIGHT = 600;
    private Player currentPlayer;
    //private static JOptionPane jp = new JOptionPane();
    private ArrayList<GameCard> hand;
	
	public CardChoosingDialogBox(Player human) {
		
		frame.setSize(1500, 400);
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		this.setModalityType(DEFAULT_MODALITY_TYPE); // Set to Modal
		BoxLayout dialogLayout = new BoxLayout(dialogPanel, BoxLayout.X_AXIS);
        dialogPanel.setLayout(dialogLayout); // Thinking BoxLayout
        this.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
        dialogPanel.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
        currentPlayer = human;
        
        for(int i = 0; i < human.getHandOfCards().size(); i++ ) {
        	images.add(new JLabel(human.getHandOfCards().get(i).getCardImage()));
        	dialogPanel.add(images.get(i));
        }
        
        final class ButtonListener implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}

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
        for(int i = 0; i < images.size();i++) {
			images.get(i).addMouseListener(new ButtonListener());
		}
        
        frame.add(dialogPanel);
        frame.setVisible(true);
		
	}
	
//	public void showCardsToDiscard() {
//		//for(int i = 0; i < hand.size(); i++) {
//			System.out.println("\n\nTEST" + 0 + "\n\n");
//			JLabel a = new JLabel(currentPlayer.getHandOfCards().get(0).getCardImage());
//			dialogPanel.add(a);
////
//	}
	
	public void chooseCardToDiscard() {
		//Checks if human player
    	if(currentPlayer.checkIfHumanPlayer()) {
    		
	    	JDialog.setDefaultLookAndFeelDecorated(true);
	    	Object[] objectCards = new Object[currentPlayer.getHandOfCards().size()];
	    	
	    	for(int i = 0; i < currentPlayer.getHandOfCards().size(); i++) {
	    		objectCards[i] = currentPlayer.getHandOfCards().get(i).getCardName();
	    	}
	    	
			Object selection = JOptionPane.showInputDialog(frame, "Choose a card to discard",
	                "Choice", JOptionPane.QUESTION_MESSAGE, null, objectCards, currentPlayer.getHandOfCards().get(0));
	    	
	    	//JOptionPane.showMessageDialog((Component)dialogPanel, selection, "Discard Card", JOptionPane.PLAIN_MESSAGE, currentPlayer.getHandOfCards().get(0).getCardImage());
	    	//jp.add(dialogPanel);
	    	
    		System.out.println("\n\nSELECTION: " + selection + "\n\n");		//Debugging

	    	for(int i = 0; i < currentPlayer.getHandOfCards().size(); i++) {
	    		
    			if(selection.equals(currentPlayer.getHandOfCards().get(i).getCardName())) {
    				currentPlayer.getHandOfCards().remove(currentPlayer.getHandOfCards().get(i));
	    		}
	    	}
	    	frame.setVisible(false);
    	}
	}

}
