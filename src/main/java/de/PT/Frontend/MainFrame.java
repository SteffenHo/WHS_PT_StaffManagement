package de.PT.Frontend;

import de.PT.personalAdministration.Management;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends javax.swing.JFrame{

    private Management staffManagement;
    private  Overview overview;
    private StattTableModel staff;
    private JTable table;
    public MainFrame(Management man){
        staffManagement = man;
        staffManagement.addMainFram(this);
        staff = new StattTableModel(staffManagement);
        initGui();
    }

    private void initGui(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setJMenuBar(new CustomMenuBar().getMenu(staffManagement));

        JPanel over = new JPanel();
        table = new JTable(staff);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        over.add(scrollPane);
        getContentPane().add(over, BorderLayout.CENTER);
    }

    public void refresh(){
        staff = new StattTableModel(staffManagement);
        table.setModel(staff);

        staff.fireTableDataChanged();
    }
}

