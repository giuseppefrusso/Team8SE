/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui.datamodels;

import it.unisa.team8se.Activity;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cptso
 */
public class ActivityTableDataModel extends AbstractTableModel {

    private LinkedList<Activity> activities;
    
    public ActivityTableDataModel(LinkedList<Activity> activities) {
        this.activities = activities;
    }   
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "AREA";
            case 2:
                return "TYPOLOGY";
            case 3:
                return "E.I.T.";
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return activities.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return activities.get(rowIndex).getID();
            case 1:
                return activities.get(rowIndex).getArea();
            case 2:
                return activities.get(rowIndex).getTipology();
            case 3:
                return activities.get(rowIndex).getEIT();
            default:
                return null;
        }
    }
}
