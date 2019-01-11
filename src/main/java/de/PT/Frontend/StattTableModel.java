package de.PT.Frontend;

import de.PT.interfaces.Size;
import de.PT.personal.AbstractEmployee;
import de.PT.personal.Manager;
import de.PT.personalAdministration.Management;
import de.PT.utils.Const;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class StattTableModel extends AbstractTableModel {

    private Management man;
    private ArrayList<AbstractEmployee> list;

    public StattTableModel(Management man){
        this.man = man;
        list = new ArrayList<AbstractEmployee>( man.getPersonalList().values());
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return Const.getColumnNames().length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return Const.getColumnNames()[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println(rowIndex + ":" + columnIndex);
        AbstractEmployee employee = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return employee.getId();
            case 1:
                return employee.getName();
            case 2:
                return employee.getSalary();
            case 3:
                return employee.getDateOfEmployment();
            case 4:
                return employee.getSize();
            case 5:
                return (employee instanceof Manager);
            case 6:
                return (employee instanceof Manager) ? ((Manager) employee).getBonus(): 0;
        }

        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Date.class;
            case 4:
                return Size.class;
            case  5:
                return Boolean.class;
            case  6:
                return Double.class;
        }
        return null;
    }

}
