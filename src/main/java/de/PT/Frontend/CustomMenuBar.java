package de.PT.Frontend;

import de.PT.personalAdministration.Management;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class CustomMenuBar {
    private JMenuBar menu;
    private Management man;

    public JMenuBar getMenu(Management man) {
        this.man = man;
        if(menu == null){
            createMenu();
        }
        return menu;
    }

    public void createMenu(){
        menu = new JMenuBar();
        menu.add(createFileMenu());
        menu.add(createEmployeeMenu());

    }

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        //new
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener((event) -> System.out.println("new " + event));
        fileMenu.add(newItem);

        //save
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener((event) -> System.out.println("save " + event));
        fileMenu.add(saveItem);

        JMenuItem refreshItem = new JMenuItem("Refresh");
        refreshItem.addActionListener((event) -> {
            System.out.println("Refresh " + event);
        });
        fileMenu.add(refreshItem);

        JSeparator sep = new JSeparator();
        fileMenu.add(sep);
        //exit
        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(eMenuItem);
        return fileMenu;
    }

    private JMenu createEmployeeMenu(){
        JMenu empleyeeMenu = new JMenu("Personal");
        empleyeeMenu.setMnemonic(KeyEvent.VK_P);

        //new
        JMenuItem newItem = new JMenuItem("Erstellen");
        newItem.addActionListener((event) -> {
            System.out.println("Erstellen " + event);
            new CustomDialog("Erstellen", new AddPerson().getView(man)).setVisible(true);
        });
        empleyeeMenu.add(newItem);

        //edit
        JMenuItem editItem = new JMenuItem("Bearbeiten");
        editItem.addActionListener((event) -> System.out.println("Bearbeiten " + event));
        empleyeeMenu.add(editItem);

        //delete
        JMenuItem deleteItem = new JMenuItem("Entfernen");
        deleteItem.addActionListener((event) -> System.out.println("Entfernen " + event));
        empleyeeMenu.add(deleteItem);

        //increase
        JMenuItem salaryItem = new JMenuItem("Gehaelter");
        salaryItem.addActionListener((event) -> System.out.println("Gehaelter " + event));
        empleyeeMenu.add(salaryItem);

        return empleyeeMenu;
    }
}
