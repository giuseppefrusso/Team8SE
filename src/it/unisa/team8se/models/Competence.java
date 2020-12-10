package it.unisa.team8se.models;

import it.unisa.team8se.models.base.DatabaseModel;
import it.unisa.team8se.DatabaseContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:35
 */
public class Competence extends DatabaseModel {

    private int id;
    private String descrizione;

    public Competence() {

    }

    public Competence(int ID, String Descrizione) {
        this.id = ID;
        this.descrizione = Descrizione;
    }

    public int getID() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public void setDescrizione(String Descrizione) {
        this.descrizione = Descrizione;
    }

    public static Competence[] getAllCompetencesOfMaintainer(String username) {
        String sql = "select C.id as id, C.descrizione as descrizione from competenza C "
                + "join possesso P on C.id = P.id where P.maintainer=? order by descrizione";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, username);
            LinkedList<Competence> instances = DatabaseContext.fetchAllModels(Competence.class, ps);
            return Arrays.copyOf(instances.toArray(), instances.size(), Competence[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Competence[] getAllDatabaseInstances() {
        String sql = "select * from competenza";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<Competence> instances = DatabaseContext.fetchAllModels(Competence.class, ps);
            return Arrays.copyOf(instances.toArray(), instances.size(), Competence[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Competence getInstanceWithPK(int id) {
        String sql = "select * from competenza where id = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setInt(1, id);
            LinkedList<Competence> instances = DatabaseContext.fetchAllModels(Competence.class, ps);
            if (instances.size() > 0) {
                return instances.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Competence getInstanceWithDescription(String desc) {
        String sql = "select * from competenza where lower(descrizione) = lower(?)";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, desc);
            LinkedList<Competence> instances = DatabaseContext.fetchAllModels(Competence.class, ps);
            if (instances.size() > 0) {
                return instances.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveToDatabase() {
        try {
            String sql = "insert into competenza (descrizione, id) values (?, ?)";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);

            ps.setInt(2, getID());
            ps.setString(1, getDescrizione());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Competence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        id = rs.getInt("id");
        descrizione = rs.getString("descrizione");
    }

    @Override
    public boolean existsInDatabase() {
        return Competence.getInstanceWithPK(getID()) != null || Competence.getInstanceWithDescription(getDescrizione()) != null;
    }
}//end Competence
