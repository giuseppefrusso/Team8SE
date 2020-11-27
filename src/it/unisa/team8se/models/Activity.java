package it.unisa.team8se.models;

import it.unisa.team8se.models.base.DatabaseModel;
import it.unisa.team8se.DatabaseContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:32
 */
public class Activity extends DatabaseModel{

    private int ID;
    private Area Area;
    private String Tipology;
    private int EIT;
    private int WeekNumber;
    private String WorkspaceNotes;
    private String InterventionDescription;
    private int SMP;
    private boolean Interruptible;
    private LinkedList<Competence> requiredCompetencies;

    public Activity() {

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

    public int getSMP() {
        return SMP;
    }

    public boolean isInterruptible() {
        return Interruptible;
    }

    public String getWorkspaceNotes() {
        return WorkspaceNotes;
    }

    public void setWorkspaceNotes(String WorkspaceNotes) {
        this.WorkspaceNotes = WorkspaceNotes;
    }

    public String getInterventionDescription() {
        return InterventionDescription;
    }

    public void setInterventionDescription(String InterventionDescription) {
        this.InterventionDescription = InterventionDescription;
    }

    public LinkedList<Competence> getRequiredCompetencies() {
        return requiredCompetencies;
    }

    public void addRequiredCompetence(Competence c) {
        requiredCompetencies.add(c);
    }

    
   
    public static Activity[] getAllDatabaseInstances() {
        try {            
            String sql = "select * from attivita_pianificata";
            LinkedList<Activity> list = DatabaseContext.fetchAllModels(Activity.class, DatabaseContext.getPreparedStatement(sql));
            return Arrays.copyOf(list.toArray(),list.size(),Activity[].class);
            
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Activity getInstanceWithPK(int ID) {
        String sql = "select * from attivita_pianificata where id = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, ID);
            LinkedList<Activity> list = DatabaseContext.fetchAllModels(Activity.class, ps);
            if (list.size() > 0)
                return (Activity)list.get(0);
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Activity[] getInstancesWithWeekNumber(int weekNumber){
        String sql = "select * from attivita_pianificata where week_number = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, weekNumber);
            LinkedList<Activity> list = DatabaseContext.fetchAllModels(Activity.class, ps);
            return Arrays.copyOf(list.toArray(),list.size(),Activity[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Activity[] getAllInstancesAssignedToMaintainer(Maintainer m)
    {
        return null;
    }
    
   
    @Override
    public String toString() {
        return "Activity{" + "ID=" + ID + ", Area=" + Area + ", Tipology=" + Tipology 
                + ", EIT=" + EIT + ", WeekNumber=" + WeekNumber + ", WorkspaceNotes=" 
                + WorkspaceNotes + ", InterventionDescription=" + InterventionDescription + ", Interruptible=" 
                + Interruptible + ", requiredCompetencies=" + requiredCompetencies + '}';
    }

    @Override
    public void saveToDatabase() {
        try {
            String sql = "insert into attivita_pianificata "
                     + "(id, area, luogo_geografico, ambito, week_number, interrompibile, workspace_notes, eta)"
                     + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1,getID());
            ps.setString(2,getArea().getSector());
            ps.setString(3,getArea().getLocation());
            ps.setString(4,getTipology());
            ps.setInt(5, getWeekNumber());
            ps.setBoolean(6, isInterruptible());
            ps.setString(7, getWorkspaceNotes());
            ps.setInt(8, getEIT());
   
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
       setID(rs.getInt("id"));
       setEIT(rs.getInt("eta"));
       setWeekNumber(rs.getInt("week_number"));

       setTipology(rs.getString("ambito"));
       setWorkspaceNotes(rs.getString("workspace_notes"));
        //setInterventionDescription("intervention_description");

       setInterruptible(rs.getBoolean("interrompibile"));

       setArea(new Area(rs.getString("area"),rs.getString("luogo_geografico")));
    }

}


     /*
    LinkedList<Activity> activities = new LinkedList<>();
    try {
    PreparedStatement ps = DatabaseContext.getConnection().prepareStatement(sql);
    ResultSet results = ps.executeQuery();
    while (results.next()) {
    Activity activity = new Activity();
    activity.getFromResultSet(results);
    activities.add(activity);
    }
    return (Activity[])activities.toArray();
    } catch (SQLException ex) {
    Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;*/