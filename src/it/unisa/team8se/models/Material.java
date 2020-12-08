package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.DatabaseModel;
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
 * @created 22-nov-2020 11:33:37
 */
public class Material extends DatabaseModel{

    private String name;
    private String description;

    public Material(){

    }

    public Material(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
	    
    public static Material[] getAllDatabaseInstances() {
        String sql = "select * from materiale";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<Material> instances = DatabaseContext.fetchAllModels(Material.class, ps);
            return Arrays.copyOf(instances.toArray(),instances.size(),Material[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public static Material getInstanceWithPK(String name) {
        String sql = "select * from materiale where nome = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1,name);
            LinkedList<Material> instances = DatabaseContext.fetchAllModels(Material.class, ps);
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
    public void saveToDatabase() {
        String sql = "insert into materiale (nome,descrizione) values (?,?)";
        try (PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);){            
            ps.setString(1,getName());
            ps.setString(2,getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        name = rs.getString("nome");
        description = rs.getString("descrizione");
    }

    @Override
    public boolean existsInDatabase() {
        return Material.getInstanceWithPK(getName()) != null;
    }
}//end Material