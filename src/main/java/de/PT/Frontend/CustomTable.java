package de.PT.Frontend;

import javax.swing.*;

public class CustomTable {

    JTable table;

    public JTable getTable(String[] column, Object[][] data){
        if(table == null){
            createTable(column, data);
        }
        return table;
    }

    private void createTable(String[] column, Object[][] data){

        table = new JTable(data, column);
    }
}
