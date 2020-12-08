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
    
    public String getSector() {
        return sector;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return sector + " - "+ location;
    }
    
    public static LinkedList<String> getAllLocations() {
        String sql = "select distinct luogo_geografico from area order by luogo_geografico";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            LinkedList<String> instances = new LinkedList<>();
            while(rs.next()) {
                instances.add(rs.getString(1));
            }
            return instances;
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static LinkedList<Area> getAllSectorsOf(String location) {
        String sql = "select * from area where luogo_geografico = ? order by nome";
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
        String sql = "select * from area where nome = ? and luogo_geografico = ? order by luogo_geografico, nome";
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
    
    public void removeFromDatabaseWithLocation() throws SQLException {
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