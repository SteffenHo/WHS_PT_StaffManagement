package de.PT.Frontend;

import de.PT.interfaces.DialogContent;
import de.PT.personal.Employee;
import de.PT.personal.Manager;
import de.PT.personalAdministration.Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

public class AddPerson implements DialogContent {

    private JPanel panel;
    private JLabel lblBonus;
    private JTextField txtBonus;
    private JButton btnSave;
    private CustomDialog parent;

    public AddPerson(Management man) {
        panel = createView(man);
    }

    public JPanel getView(){
        return panel;
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
        //btnManager.addActionListener((event) -> addManagement(event));
        btnManager.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    addManagement();
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    removeManagement();
                }
            }
        });
        JRadioButton btnEmployee = new JRadioButton("Employee", true);
        //btnEmployee.addActionListener((event) -> removeManagement());

        btnSave = new JButton("Speichern");
        btnSave.addActionListener((event) ->{
            double sallary = 0;
            double bonus = 0;
            try {
                sallary =  Double.parseDouble(txtSalary.getText());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(man.mainFrame, "Das Gehalt ist keine gueltige Eingabe");
                return;
            }

            try {
                if(btnManager.isSelected()){
                    bonus = Double.parseDouble(txtBonus.getText());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(man.mainFrame, "Der Bonus ist keine gueltige Eingabe");
                return;
            }
            if(btnManager.isSelected()){
                man.add(new Manager(txtName.getText(), sallary, new Date(), Integer.parseInt(lblIdContent.getText()), bonus));
            } else {
                man.add(new Employee(txtName.getText(), sallary, new Date(), Integer.parseInt(lblIdContent.getText())));
            }
            close();
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
        panel = view;
        return view;
    }

    private void addManagement(){
        panel.remove(btnSave);
         lblBonus = new JLabel("Bonus");
         txtBonus = new JTextField();

        panel.add(lblBonus);
        panel.add(txtBonus);
        panel.add(btnSave);
        panel.revalidate();
        panel.repaint();
    }

    private void removeManagement(){
        if(lblBonus == null) return;
        panel.remove(lblBonus);
        panel.remove(txtBonus);
        panel.validate();
        panel.repaint();
    }

    @Override
    public void setCloseOperation(CustomDialog parent) {
        this.parent = parent;
    }

    @Override
    public void close() {
        parent.close();
    }
}
