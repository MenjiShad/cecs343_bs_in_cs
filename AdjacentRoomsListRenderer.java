package cecs343_bs_in_cs;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;

/**
 *
 * @author James
 * 
 * This class was implemented to allow a JList of Rooms to display room names
 * and not address locations
 */
public class AdjacentRoomsListRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	public AdjacentRoomsListRenderer() {
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Room) {
            Room room = (Room) value;
            setText(room.toString());
        }
        
        return this;
    }
}
