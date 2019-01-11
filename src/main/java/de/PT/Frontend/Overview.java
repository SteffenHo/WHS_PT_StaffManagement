package de.PT.Frontend;

import de.PT.personalAdministration.Management;
import de.PT.utils.Const;

import javax.swing.*;
import java.awt.*;

public class Overview {

    private JPanel overview;
    private JTable table;

    public JPanel getOverview(Management man) {
        if(overview == null){
            createOverview(man);
        }
        return overview;
    }

    private JPanel createOverview(Management man){

        overview = new JPanel();
        table = new CustomTable().getTable(Const.getColumnNames(), man.getPersonalListForTable());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        overview.add(scrollPane, BorderLayout.CENTER);
        return overview;
    }


}
