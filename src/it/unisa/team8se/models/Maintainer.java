/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import java.util.LinkedList;

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
        return null;
    }

    
    public static Maintainer getInstanceWithPK(Object... pk) {
        return null;
    }

    
    public void saveToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
