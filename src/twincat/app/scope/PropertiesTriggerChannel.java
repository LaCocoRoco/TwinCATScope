package twincat.app.scope;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import twincat.app.constants.Resources;

public class PropertiesTriggerChannel extends JScrollPane {
   private static final long serialVersionUID = 1L;
    
    /*************************/
    /****** constructor ******/
    /*************************/
     
    public PropertiesTriggerChannel() {
        this.getVerticalScrollBar().setPreferredSize(new Dimension(Resources.DEFAULT_SCROLLBAR_WIDTH, 0));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setViewportView(new LoremIpsum());
    }
}