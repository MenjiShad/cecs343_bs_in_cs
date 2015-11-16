package cecs343_bs_in_cs;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Generates a customized dialog box to allow
 * the user to select their "chip of choice"
 */
public class ChipChoosingDialogBox extends JDialog {
    
    private JPanel dialogPanel;
    private JButton learningButton;
    private JButton craftButton;
    private JButton integrityButton;
    private static final int DIALOG_BOX_WIDTH = 800;
    private static final int DIALOG_BOX_HEIGHT = 600;
    
    public ChipChoosingDialogBox(boolean learningEnable, boolean craftEnable,
            boolean integrityEnable) {
        this.setModalityType(DEFAULT_MODALITY_TYPE); // Set to Modal
        dialogPanel.setLayout(new FlowLayout()); // Thinking BoxLayout
        this.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
        dialogPanel.setSize(DIALOG_BOX_WIDTH, DIALOG_BOX_HEIGHT); // May change
        
        // After 1 button is pressed, the dialog box should close
        // Notify the model on what button was pressed
        
        
        // Implement Action Listeners for the 3 buttons
        

        
        // setEnabled(boolean) on the 3 buttons
        learningButton.setEnabled(learningEnable);
        craftButton.setEnabled(craftEnable);
        integrityButton.setEnabled(integrityEnable);
        
        // add Buttons to the panel
        dialogPanel.add(learningButton);
        dialogPanel.add(craftButton);
        dialogPanel.add(integrityButton);
        
        // add panel to the dialog box
        this.add(dialogPanel);
    }

}
