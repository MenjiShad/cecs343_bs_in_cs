/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs343_bs_in_cs;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
/**
 *
 * @author James
 */
public class AdjacentRoomsListRenderer extends DefaultListCellRenderer {

    public AdjacentRoomsListRenderer() {
        setOpaque(true);
    }
    
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
