/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui.datamodels;

import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Competence;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cptso
 */
class MaintainerAvailabilityDataModel extends AbstractTableModel {

    private LinkedList<Competence> competencies;

    public MaintainerAvailabilityDataModel(LinkedList<Competence> competencies ) {
        this.competencies = competencies;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "MAINTAINER";
            case 1:
                return "SKILL";
            case 2:
                return "KNOWLEDGE";
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return competencies.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return competencies.get(rowIndex).getcompentencies

        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}