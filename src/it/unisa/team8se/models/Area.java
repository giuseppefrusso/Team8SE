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
 * @created 22-nov-2020 11:33:34
 */
public class Area extends DatabaseModel{

    private String sector;
    private String location;

    public Area(){

    }

    public Area(String sector, String location) {
        this.sector = sector;
        this.location = location;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void finalize() throws Throwable {

    }

    public String getSector() {
        return sector;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        return sector + " - "+ location;
    }
    
    public static LinkedList<Area> getAllDatabaseInstances() {
        String sql = "select * from area";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<Area> instances = DatabaseContext.fetchAllModels(Area.class, ps);
            return instances;
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static LinkedList<Area> getAllSectorsOf(String location) {
        String sql = "select * from area where luogo_geografico = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, location);
            LinkedList<Area> sectors = DatabaseContext.fetchAllModels(Area.class, ps);
            return sectors;
        } catch (SQLException ex) {
            Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Area getInstanceWithPK(String sector, String location) {
        String sql = "select * from area where nome = ? and luogo_geografico = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, sector);
            ps.setString(2, location);
            LinkedList<Area> instances = DatabaseContext.fetchAllModels(Area.class, ps);
            if(instances.size() > 0){
                return instances.get(0);
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveToDatabase() throws SQLException{
        String sql = "insert into area(nome, luogo_geografico) "
                + "values(?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, sector);
        ps.setString(2, location);
        if(ps.executeUpdate()<1)
            throw new SQLException();
        ps.close();
    }
    
    public static void removeFromDatabaseWithLocation(String location) throws SQLException {
        String sql = "delete from area where luogo_geografico=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, location);
        if(ps.executeUpdate()<1)
            throw new SQLException();
        ps.close();
    }

    public void removeFromDatabase() throws SQLException {
        String sql = "delete from area where nome=? and luogo_geografico=?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, sector);
        ps.setString(2, location);
        if(ps.executeUpdate()<1)
            throw new SQLException();
        ps.close();
    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        sector = rs.getString("nome");
        location = rs.getString("luogo_geografico");
    }

    @Override
    public boolean existsInDatabase() {
        return Area.getInstanceWithPK(getSector(), getLocation()) != null;
    }
}//end Area