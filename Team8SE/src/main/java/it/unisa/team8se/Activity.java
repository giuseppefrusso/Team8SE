package it.unisa.team8se;


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