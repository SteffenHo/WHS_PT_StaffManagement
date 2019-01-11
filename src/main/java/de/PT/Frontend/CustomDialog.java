package de.PT.Frontend;

import de.PT.interfaces.DialogContent;

import javax.swing.*;
import javax.swing.border.Border;

public class CustomDialog extends JDialog {


    public CustomDialog(String name, DialogContent content ) {
        createUI(name, content);
    }
    public void createUI(String name, DialogContent content){
        setTitle(name);
        getContentPane().add(content.getView());
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        content.getView().setBorder(padding);
        content.setCloseOperation(this);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(null);
        setSize(250, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void close(){
        dispose();
    }
}
