package de.PT.Frontend;

import javax.swing.*;
import java.awt.*;

public class CustomDialog extends JDialog {


    public CustomDialog(String name, JPanel content ) {

        createUI(name, content);
    }
    public void createUI(String name, JPanel content){
        setTitle(name);
        getContentPane().add(content);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setLocationRelativeTo(null);
        setSize(150, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
