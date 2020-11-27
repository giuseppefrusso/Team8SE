/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class Maintainer extends User{
    
    private LinkedList<Competence> competencies;

    public Maintainer(String surname, String name, String username, String password) {
        super(surname, name, username, password, "Maintainer");
        competencies = new LinkedList<>();
    }

    public Maintainer(){
        super();
        competencies = new LinkedList<>();
    }
    
    public LinkedList<Competence> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(LinkedList<Competence> competencies) {
        this.competencies = competencies;
    }
    
    public void addCompetence(Competence c){
        this.competencies.add(c);
    }
    
    public void removeCompetence(int ID){
        
    }
    
        
    public static Maintainer[] getAllDatabaseInstances() {
        String sql = "select * from maintainer";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ResultSet results = ps.executeQuery();
            LinkedList<Maintainer> instances = DatabaseContext.fetchAllModels(Maintainer.class, ps);
            return Arrays.copyOf(instances.toArray(),instances.size(),Maintainer[].class);
        } catch (SQLException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public static Maintainer getInstanceWithPK(String username) {
        String sql = "select * from maintainer where username = ?";
        try {
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, username);
            ResultSet results = ps.executeQuery();
            LinkedList<Maintainer> instances = DatabaseContext.fetchAllModels(Maintainer.class, ps);
            if(instances.size() > 0 ){
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
    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException{
        super.getFromResultSet(rs);
        //TODO: get delle competenze
    }
}
