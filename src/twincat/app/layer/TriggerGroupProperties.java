package twincat.app.layer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import twincat.Resources;
import twincat.java.ScrollablePanel;
import twincat.java.WrapLayout;
import twincat.scope.TriggerGroup;

public class TriggerGroupProperties extends JPanel {
    private static final long serialVersionUID = 1L;

    /*********************************/
    /******** global variable ********/
    /*********************************/

    private TriggerGroup triggerGroup = new TriggerGroup();

    /*********************************/
    /****** local final variable *****/
    /*********************************/

    private final ResourceBundle languageBundle = ResourceBundle.getBundle(Resources.PATH_LANGUAGE);

    /*********************************/
    /********** constructor **********/
    /*********************************/

    public TriggerGroupProperties(XReference xref) {
        ScrollablePanel contentPanel = new ScrollablePanel();
        contentPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
        contentPanel.setBorder(BorderFactory.createEmptyBorder());
        contentPanel.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);

        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setBorder(BorderFactory.createEmptyBorder());
        scrollPanel.setViewportView(contentPanel);

        JLabel textHeader = new JLabel(languageBundle.getString(Resources.TEXT_TRIGGER_GROUP_PROPERTIES_TITLE));
        textHeader.setFont(new Font(Resources.DEFAULT_FONT, Font.BOLD, Resources.DEFAULT_FONT_SIZE_NORMAL));
        textHeader.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setLayout(new BorderLayout());
        this.add(textHeader, BorderLayout.PAGE_START);
        this.add(scrollPanel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder());
    }

    /*********************************/
    /******** setter & getter ********/
    /*********************************/
    
    public TriggerGroup getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(TriggerGroup triggerGroup) {
        this.triggerGroup = triggerGroup;
    }       
}
