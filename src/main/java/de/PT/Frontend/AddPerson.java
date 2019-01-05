package de.PT.Frontend;

import de.PT.personal.AbstractEmployee;
import de.PT.personal.Employee;
import de.PT.personal.Manager;
import de.PT.personalAdministration.Management;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AddPerson {

    public JPanel getView(Management man){
        return createView(man);
    }

    private JPanel createView(Management man){
        JPanel view = new JPanel();
        GridLayout experimentLayout = new GridLayout(0,2, 10, 10);
        view.setLayout(experimentLayout);

        JLabel lblName = new JLabel("Name");
        JLabel lblSalary = new JLabel("Gehalt");
        JLabel lblId = new JLabel("ID");
        JLabel lblIdContent = new JLabel(String.valueOf(man.getNextId()));
        JTextField txtName = new JTextField();
        JTextField txtSalary = new JTextField();

        JRadioButton btnManager = new JRadioButton("Manager", false);
        JRadioButton btnEmployee = new JRadioButton("Employee", true);

        JButton btnSave = new JButton("Speichern");
        btnSave.addActionListener((event) ->{
            if(btnManager.isSelected()){
                man.add(new Manager(txtName.getText(), Double.parseDouble(txtSalary.getText()), new Date(), Integer.parseInt(lblIdContent.getText()), 0));
            } else {
                man.add(new Employee(txtName.getText(), Double.parseDouble(txtSalary.getText()), new Date(), Integer.parseInt(lblIdContent.getText())));
            }
        });

        ButtonGroup stuff = new ButtonGroup();
        stuff.add(btnEmployee);
        stuff.add(btnManager);
        view.add(lblId);
        view.add(lblIdContent);
        view.add(lblName);
        view.add(txtName);
        view.add(lblSalary);
        view.add(txtSalary);
        view.add(btnEmployee);
        view.add(btnManager);
        view.add(btnSave);
        return view;
    }


}
