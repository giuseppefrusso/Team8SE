package it.unisa.team8se.models;

import it.unisa.team8se.models.base.DatabaseModel;
import it.unisa.team8se.DatabaseContext;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:32
 */
public class Activity extends DatabaseModel {

    private int ID;
    private Area Area;
    private String tipology;
    private int eit;
    private int weekNumber;
    private String workspaceNotes;
    private String interventionDescription;
    private boolean interruptible;
    private Timestamp datetime;
    private String smpIdentifier;

    private SMP smp;
    private LinkedList<Material> usedMaterials;
    private LinkedList<Competence> requiredCompetences;

    public Activity() {
        this.requiredCompetences = new LinkedList<>();
        this.usedMaterials = new LinkedList<>();
    }

    public Activity(int ID) {
        this.ID = ID;
        this.requiredCompetences = new LinkedList<>();
        this.usedMaterials = new LinkedList<>();
    }

    public Activity(int ID, Area Area, String tipology, int weekNumber, Timestamp datetime, int eit, boolean interruptible) {
        this.ID = ID;
        this.Area = Area;
        this.tipology = tipology;
        this.eit = eit;
        this.weekNumber = weekNumber;
        this.interruptible = interruptible;
        this.datetime = datetime;
    }

    public Activity(int ID, Area Area, String Tipology, int EIT, int WeekNumber, String WorkspaceNotes, String InterventionDescription, boolean Interruptible, Timestamp datetime) {
        this.ID = ID;
        this.Area = Area;
        this.tipology = Tipology;
        this.eit = EIT;
        this.weekNumber = WeekNumber;
        this.workspaceNotes = WorkspaceNotes;
        this.interventionDescription = InterventionDescription;
        this.interruptible = Interruptible;
        this.datetime = datetime;
        this.usedMaterials = new LinkedList<>();
        this.requiredCompetences = new LinkedList<>();
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
        this.tipology = Tipology;
    }

    public void setEIT(int EIT) {
        this.eit = EIT;
    }

    public void setWeekNumber(int WeekNumber) {
        this.weekNumber = WeekNumber;
    }

    public void setInterruptible(boolean Interruptible) {
        this.interruptible = Interruptible;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Area getArea() {
        return Area;
    }

    public String getTipology() {
        return tipology;
    }

    public int getEIT() {
        return eit;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public boolean isInterruptible() {
        return interruptible;
    }

    public String getWorkspaceNotes() {
        return workspaceNotes;
    }

    public void setWorkspaceNotes(String WorkspaceNotes) {
        if (WorkspaceNotes != null && WorkspaceNotes.length() > 100) {
            WorkspaceNotes = WorkspaceNotes.substring(0, 99);
        }
        this.workspaceNotes = WorkspaceNotes;
    }

    public String getInterventionDescription() {
        return interventionDescription;
    }

    public void setInterventionDescription(String InterventionDescription) {
        if (InterventionDescription != null && InterventionDescription.length() > 50) {
            InterventionDescription = InterventionDescription.substring(0, 49);
        }
        this.interventionDescription = InterventionDescription;
    }

    public String getSmpIdentifier() {
        return smpIdentifier;
    }

    public LinkedList<Competence> getRequiredCompetences() {
        return requiredCompetences;
    }

    public void addRequiredCompetence(Competence c) {
        requiredCompetences.add(c);
    }

    public SMP getSmp() {
        if (smp == null) {
            smp = SMP.getInstanceWithPK(smpIdentifier);
        }
        return smp;
    }

    public void setSmp(SMP smp) {
        this.smp = smp;
    }

    public static int getMaxId() throws SQLException {
        int maxId;
        String sql = "select max(id) from attivita_pianificata";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            maxId = rs.getInt(1);
        } else {
            maxId = 0;
        }
        rs.close();
        ps.close();
        return maxId;
    }

    public static Activity[] getAllDatabaseInstances() {
        try {
            String sql = "select * from attivita_pianificata order by ID";
            LinkedList<Activity> list = DatabaseContext.fetchAllModels(Activity.class, DatabaseContext.getPreparedStatement(sql));
            return Arrays.copyOf(list.toArray(), list.size(), Activity[].class);
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
            if (list.size() > 0) {
                return (Activity) list.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Maintainer getMaintainer() {
        Maintainer m = null;
        String sql = "select maintainer "
                + "from attivita_pianificata"
                + "where id = ?";
        PreparedStatement ps;
        try {
            ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = Maintainer.getInstanceWithPK(rs.getString(1));
                System.out.println(rs.getString(1));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    public static Activity[] getInstancesAssignedToMaintainer(Maintainer m) {
        String sql = "select * from attivita_pianificata where maintainer = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, m.getUsername());
            LinkedList<Activity> list = DatabaseContext.fetchAllModels(Activity.class, ps);
            return Arrays.copyOf(list.toArray(), list.size(), Activity[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Activity[] getInstancesWithWeekNumber(int weekNumber) {
        String sql = "select * from attivita_pianificata where week_number = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, weekNumber);
            LinkedList<Activity> list = DatabaseContext.fetchAllModels(Activity.class, ps);
            return Arrays.copyOf(list.toArray(), list.size(), Activity[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public LinkedList<Competence> getRequiredCompetencesFromDatabase() throws SQLException {
        String sql = "select C.id, C.descrizione "
                + "from requisito_planned R, competenza C "
                + "where R.attivita_pianificata = ? and C.id = R.competenza "
                + "order by C.descrizione";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, getID());
        LinkedList<Competence> comp = DatabaseContext.fetchAllModels(Competence.class, ps);
        requiredCompetences = comp;
        return comp;
    }

    public LinkedList<Material> getUsedMaterialsFromDatabase() throws SQLException {
        String sql = "select M.nome, M.descrizione "
                + "from materiale M, uso_planned U "
                + "where M.nome = U.materiale and U.attivita_pianificata=? "
                + "order by M.nome";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, getID());
        LinkedList<Material> mat = DatabaseContext.fetchAllModels(Material.class, ps);
        usedMaterials = mat;
        return mat;
    }

    @Override
    public String toString() {
        return "Activity{" + "ID=" + ID + ", Area=" + Area + ", Tipology=" + tipology
                + ", EIT=" + eit + ", WeekNumber=" + weekNumber + ", WorkspaceNotes="
                + workspaceNotes + ", InterventionDescription=" + interventionDescription + ", Interruptible="
                + interruptible + '}';
    }

    @Override
    public void saveToDatabase() throws SQLException {

        String sql = "insert into attivita_pianificata "
                + "(id, area, luogo_geografico, ambito, week_number, interrompibile, workspace_notes, eta, data_e_ora, smp)"
                + "values(?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, getID());
        ps.setString(2, getArea().getSector());
        ps.setString(3, getArea().getLocation());
        ps.setString(4, getTipology());
        ps.setInt(5, getWeekNumber());
        ps.setBoolean(6, isInterruptible());
        ps.setString(7, getWorkspaceNotes());
        ps.setInt(8, getEIT());
        ps.setTimestamp(9, getDatetime());
        ps.setString(10, getSmp().getNome());

        int res = ps.executeUpdate();
    }

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        setID(rs.getInt("id"));
        setArea(new Area(rs.getString("area"), rs.getString("luogo_geografico")));
        setEIT(rs.getInt("eta"));
        setWeekNumber(rs.getInt("week_number"));
        setTipology(rs.getString("ambito"));
        setWorkspaceNotes(rs.getString("workspace_notes"));
        setDatetime(rs.getTimestamp("data_e_ora"));
        setInterruptible(rs.getBoolean("interrompibile"));
        setInterventionDescription(rs.getString("descrizione_intervento"));

        smpIdentifier = rs.getString("smp");
    }

    @Override
    public boolean existsInDatabase() {
        return Activity.getInstanceWithPK(getID()) != null;
    }

    public void removeFromDatabase() throws SQLException {
        String sql = "delete from attivita_pianificata where id = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, ID);
        ps.executeUpdate();
        ps.close();
    }

    public void updateInterventionDescInDatabase() {
        String sql = "update attivita_pianificata set descrizione_intervento = ? where id = ?";
        try (PreparedStatement ps = DatabaseContext.getPreparedStatement(sql)) {
            ps.setString(1, getInterventionDescription());
            ps.setInt(2, getID());
            int res = ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void updateWorkspaceNotesInDatabase() {
        String sql = "update attivita_pianificata set workspace_notes = ? where id = ?";
        try (PreparedStatement ps = DatabaseContext.getPreparedStatement(sql)) {
            ps.setString(1, getWorkspaceNotes());
            ps.setInt(2, getID());
            int res = ps.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void updateInDatabase(Object newValue, String field) throws SQLException {
        String sql = "update attivita_pianificata set " + field + " = ? where id = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        if (newValue instanceof Integer) {
            ps.setInt(1, (int) newValue);
        } else if (newValue instanceof String) {
            ps.setString(1, (String) newValue);
        } else if (newValue instanceof Timestamp) {
            ps.setTimestamp(1, (Timestamp) newValue);
        } else {
            ps.setBoolean(1, (boolean) newValue);
        }
        ps.setInt(2, ID);
        ps.executeUpdate();
        ps.close();
    }

    public boolean updateSMPInDatabase() throws SQLException {
        if (!smp.existsInDatabase()) {
            return false;
        }

        String sql = "update attivita_pianificata set SMP = ? where id = ?";
        try (PreparedStatement ps = DatabaseContext.getPreparedStatement(sql)) {
            ps.setString(1, smp.getNome());
            ps.setInt(2, ID);
            ps.executeUpdate();
        }
        return true;
    }

    /*
    public boolean openSMPFromDatabase() throws SQLException, IOException, IllegalArgumentException {
        String sql = "select S.documento_pdf "
                + "from attivita_pianificata A join smp S "
                + "on A.smp = S.nome "
                + "where A.id = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            File file = new File(rs.getString(1));
            Desktop.getDesktop().open(file);
        } else {
            return false;
        }

        rs.close();
        ps.close();
        return true;
    }*/

    public boolean assignActivityToMaintainer(Maintainer m) throws SQLException {
        try {
            String sql = "update attivita_pianificata set maintainer = ? where id = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, m.getUsername());
            ps.setInt(2, ID);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.ID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Activity other = (Activity) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

    public String[] toArray() {
        String i;
        if (interruptible) {
            i = "Sì";
        } else {
            i = "No";
        }

        String[] array = {Integer.toString(ID), Area.getLocation(), Area.getSector(), tipology,
            Integer.toString(weekNumber), datetime.toString(), Integer.toString(eit), i};
        return array;
    }
}

/*
id
area
luogo_geografico
data_e_ora
planner
maintainer
descrizione_intervento
workspace_notes
smp
 */
