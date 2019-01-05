package de.PT.Frontend;

import de.PT.personalAdministration.Management;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends javax.swing.JFrame{

    private Management staffManagement;
    public MainFrame(Management man){
        staffManagement = man;
        initGui();
    }

    private void initGui(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setJMenuBar(new CustomMenuBar().getMenu(staffManagement));
        JPanel over = new Overview().getOverview(staffManagement);

        getContentPane().add(over, BorderLayout.CENTER);
    }
}
