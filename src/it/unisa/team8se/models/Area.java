package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:34
 */
public class Area{

    private String Sector;
    private String Location;

    public Area(){

    }

    public Area(String Sector, String Location) {
        this.Sector = Sector;
        this.Location = Location;
    }

    
    public void finalize() throws Throwable {

    }

    public String getSector() {
        return Sector;
    }

    public String getLocation() {
        return Location;
    }

    
    public String toString() {
        return Sector + " - "+ Location;
    }
    
    public static LinkedList<Area> getAllDatabaseInstances() {
        String sql = "select * from attivita_pianificata";
        LinkedList<Area> areas = new LinkedList<>();
        try {
            PreparedStatement ps = DatabaseContext.getConnection().prepareStatement(sql);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                areas.add(Area.getFromResultSet(results));
            }
            return areas;
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public static Area getInstanceWithPK(String sector, String location) {
        String sql = "select * from attivita_pianificata where nome = ? and luogo_geografico = ?";
        try {
            PreparedStatement ps = DatabaseContext.getConnection().prepareStatement(sql);
            ps.setString(1, sector);
            ps.setString(2, location);
            ResultSet results = ps.executeQuery();
            if (results.next()) {
                return Area.getFromResultSet(results);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static Area getFromResultSet(ResultSet rs) throws SQLException {
        return new Area(rs.getString("nome"),rs.getString("luogo_geografico"));
    }
}//end Area