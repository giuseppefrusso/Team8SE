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

    @Override
    public String toString() {
        return descrizione;
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
        String sql = "select * from competenza order by descrizione";
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

    public void updateDescription(String newDescription) throws SQLException {
        String sql = "update competenza set descrizione=? where id=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(2, id);
        this.descrizione = newDescription;
        ps.setString(1, newDescription);
        ps.executeUpdate();
        ps.close();
    }
    
    public void removeFromDatabase() throws SQLException {
        String sql = "delete from competenza where id=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
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

    public void saveIntoRequisite(int idActivity) throws SQLException {
        String query = "insert into requisito_planned(competenza, attivita_pianificata) values(?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(query);

        ps.setInt(1, this.getID());
        ps.setInt(2, idActivity);

        ps.executeUpdate();
        ps.close();
    }

    public void saveIntoPossesso(String username) throws SQLException {
        String query = "insert into possesso(id, maintainer) values(?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(query);

        ps.setInt(1, this.getID());
        ps.setString(2, username);

        ps.executeUpdate();
        ps.close();
    }

    public static void removeFromPossessoWithDescription(String competence, String username) throws SQLException {
        String query = "select C.id as id from competenza C where C.descrizione=? "
                + "intersect "
                + "select P.id as id from possesso P where P.maintainer=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(query);
        ps.setString(1, competence);
        ps.setString(2, username);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int idCompetence = rs.getInt("id");

        query = "delete from possesso where id=? and maintainer=?";
        ps = DatabaseContext.getPreparedStatement(query);
        ps.setInt(1, idCompetence);
        ps.setString(2, username);
        ps.executeUpdate();

        rs.close();
        ps.close();
    }

    public static void removeFromRequisiteWithDescription(String competence, int idActivity) throws SQLException {
        String query = "select C.id as id_competenza from competenza C where C.descrizione=? "
                + "intersect "
                + "select P.competenza as id_competenza from requisito_planned P where P.attivita_pianificata=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(query);
        ps.setString(1, competence);
        ps.setInt(2, idActivity);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int idCompetence = rs.getInt("id_competenza");

        query = "delete from requisito_planned where competenza=? and attivita_pianificata=?";
        ps = DatabaseContext.getPreparedStatement(query);
        ps.setInt(1, idCompetence);
        ps.setInt(2, idActivity);
        ps.executeUpdate();

        rs.close();
        ps.close();
    }

    public static Competence saveToDatabaseWithDescription(String competenceDesc) throws SQLException {
        Competence competence = Competence.getInstanceWithDescription(competenceDesc);
        if (competence == null) {
            competence = new Competence();
            ResultSet rs = DatabaseContext.getStatement().executeQuery("select max(id) from competenza");
            if (rs.next()) {
                int maxId = rs.getInt(1);
                competence.setID(maxId + 1);
                competence.setDescrizione(competenceDesc);
            }
            rs.close();

            competence.saveToDatabase();
        }
        return competence;
    }

    @Override
    public void saveToDatabase() throws SQLException {
        String sql = "insert into competenza (descrizione, id) values (?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);

        ps.setInt(2, getID());
        ps.setString(1, getDescrizione());

        ps.executeUpdate();
        ps.close();
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
    
    public Object[] toArray() {
        Object[] array = {id,descrizione};
        return array;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Competence other = (Competence) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}//end Competence
