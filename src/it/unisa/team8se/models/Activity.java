package it.unisa.team8se.models;
import java.sql.*;

/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:32
 */
public class Activity {

    private int ID;
    private Area Area;
    private String Tipology;
    private int EIT;
    private int WeekNumber;
    private int WorkspaceNotes;
    private int InterventionDescription;
    private int SMP;
    private boolean Interruptible;

    public Activity(){

    }

    public void finalize() throws Throwable {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setArea(Area Area) {
        this.Area = Area;
    }

    public void setTipology(String Tipology) {
        this.Tipology = Tipology;
    }

    public void setEIT(int EIT) {
        this.EIT = EIT;
    }

    public void setWeekNumber(int WeekNumber) {
        this.WeekNumber = WeekNumber;
    }

    public void setWorkspaceNotes(int WorkspaceNotes) {
        this.WorkspaceNotes = WorkspaceNotes;
    }

    public void setInterventionDescription(int InterventionDescription) {
        this.InterventionDescription = InterventionDescription;
    }

    public void setSMP(int SMP) {
        this.SMP = SMP;
    }

    public void setInterruptible(boolean Interruptible) {
        this.Interruptible = Interruptible;
    }

    public Area getArea() {
        return Area;
    }

    public String getTipology() {
        return Tipology;
    }

    public int getEIT() {
        return EIT;
    }

    public int getWeekNumber() {
        return WeekNumber;
    }

    public int getWorkspaceNotes() {
        return WorkspaceNotes;
    }

    public int getInterventionDescription() {
        return InterventionDescription;
    }

    public int getSMP() {
        return SMP;
    }

    public boolean isInterruptible() {
        return Interruptible;
    }
}//end Activity