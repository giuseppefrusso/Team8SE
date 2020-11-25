/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui.datamodels;

import it.unisa.team8se.models.Maintainer;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cptso
 */
public class MaintainerAvailabilityDataModel extends AbstractTableModel {

    private LinkedList<Maintainer> maintainers;

    public MaintainerAvailabilityDataModel(LinkedList<Maintainer> maintainers) {
        this.maintainers = maintainers;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "MAINTAINER";
            case 1:
                return "SKILLS";
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return maintainers.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return maintainers.get(rowIndex).getName();
            case 1:
                return "3/5"; //TODO: Implementare contatore delle skill in base all'attività;
            default:
                return null;
        }
    }
}
