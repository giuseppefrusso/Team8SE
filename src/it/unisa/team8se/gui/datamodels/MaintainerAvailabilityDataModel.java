/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui.datamodels;

import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cptso
 */
public class MaintainerAvailabilityDataModel extends AbstractTableModel {

    private LinkedList<Maintainer> maintainers;
    private LinkedList<Competence> requiredCompetences;

    public MaintainerAvailabilityDataModel(LinkedList<Maintainer> maintainers, Activity a) throws SQLException {
        this.maintainers = maintainers;
        this.requiredCompetences = a.getRequiredCompetencesFromDatabase();
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
    
    public void clear() {
        maintainers.clear();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return maintainers.get(rowIndex).getUsername();
            case 1:
                return maintainers.get(rowIndex).getCorrespondingCompetences(requiredCompetences)+"/"+requiredCompetences.size();
            default:
                return null;
        }
    }
}
