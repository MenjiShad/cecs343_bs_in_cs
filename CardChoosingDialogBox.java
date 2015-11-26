package cecs343_bs_in_cs;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class CardChoosingDialogBox extends JDialog{
	
    private JPanel dialogPanel;
    private static final int DIALOG_BOX_WIDTH = 800;
    private static final int DIALOG_BOX_HEIGHT = 600;
	
	public CardChoosingDialogBox(ArrayList<GameCard> playersHandOfCards) {
		this.setModalityType(DEFAULT_MODALITY_TYPE); // Set to Modal
        dialogPanel.setLayout(new FlowLayout()); // Thinking BoxLayout
        this.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
        dialogPanel.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
		
	}

}
