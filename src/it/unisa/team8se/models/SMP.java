/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.models;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.base.DatabaseModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class SMP extends DatabaseModel {

    private String nome;
    private long documentSize;
    protected byte[] document;
    private boolean tempVersionStored;

    public SMP() {
    }

    public SMP(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getDocumentSize() {
        return documentSize;
    }

    public void setDocumentSize(long documentSize) {
        this.documentSize = documentSize;
    }

    public boolean isDocumentValid(){
        return (document != null && document.length > 0) || tempVersionStored;
    }
    
    public void getDocumentFromDatabase(){
        try {
            String sql = "select documento_pdf as doc from smp where nome = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, getNome());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                document = rs.getBytes("doc");
                documentSize = document.length;
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean cleanTempDocumentFolder() {
        Path path = Paths.get(".\\temp\\");
        boolean all = true;
        if (Files.exists(path)) {
            File dir = new File(path.toUri());
            for (File f : dir.listFiles()) {
                System.out.println("deleting " + f.getName());
                if (!f.delete()) {
                    all = false;
                }
            }
            return all;
        }
        return true;
    }
    
    public void importDocument(String fullPath) throws IOException {
        document = Files.readAllBytes(Paths.get(fullPath));
        documentSize = document.length;
    }

    public void importDocument(String filePath, String fileName) throws IOException {
        importDocument(filePath + fileName + ".pdf");
    }

    public void exportDocument(String filePath, String fileName) {
        exportDocument(filePath + fileName + ".pdf");
    }

    public void exportDocument(String fullPath){
        try {
            Path path = Paths.get(fullPath);
            Files.write(path, document);
        } catch (IOException ex) {
            Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean openDocument() {
        if (document != null) {
            Path path = Paths.get(".\\temp\\");
            try {
                if (!tempVersionStored) {
                    if (!Files.exists(path)) {
                        File directory = new File(path.toUri());
                        directory.mkdir();
                    }
                    path = Paths.get(".\\temp\\" + getNome() + "_temp.pdf");
                    Files.write(path, document);
                    tempVersionStored = true;
                }
                else{
                    path = Paths.get(".\\temp\\" + getNome() + "_temp.pdf");
                }
                Desktop.getDesktop().open(new File(path.toUri()));
            } catch (IOException ex) {
                Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }
        return false;
    }
    
    public static SMP[] getAllDatabaseInstancesInfoOnly(){
        try {
            String sql = "select nome,length(documento_pdf) as size from smp";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<SMP> list = new LinkedList<SMP>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SMP s = new SMP();
                s.setNome(rs.getString("nome"));
                s.setDocumentSize(rs.getLong("size"));
                list.add(s);
            }
            rs.close();
            ps.close();
            return Arrays.copyOf(list.toArray(), list.size(), SMP[].class);
        } catch (SQLException ex) {
            Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static SMP[] getAllDatabaseInstances() {
        try {
            String sql = "select * from smp";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            LinkedList<SMP> list = DatabaseContext.fetchAllModels(SMP.class, ps);
            return Arrays.copyOf(list.toArray(), list.size(), SMP[].class);
        } catch (SQLException ex) {
            Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static SMP getInstanceWithPK(String name) {
        try {
            String sql = "select * from smp where nome = ?";
            PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
            ps.setString(1, name);
            LinkedList<SMP> list = DatabaseContext.fetchAllModels(SMP.class, ps);
            if (list != null && list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public void updateNameInDatabase(String newName) throws SQLException{
        String sql = "update smp set nome = ? where nome = ?";
        try(PreparedStatement ps = DatabaseContext.getPreparedStatement(sql)){
            ps.setString(1, newName);
            ps.setString(2, getNome());
            ps.executeUpdate();
            setNome(newName);
        }
    }
    
    public void removeFromDatabase() throws SQLException{
        String sql = "delete from smp where nome = ?";
        try(PreparedStatement ps = DatabaseContext.getPreparedStatement(sql)){
            ps.setString(1, getNome());
            ps.executeUpdate();
        }
    }
    
    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        setNome(rs.getString("nome"));
        document = rs.getBytes("documento_pdf");
        documentSize = document.length;
    }

    @Override
    public void saveToDatabase() throws SQLException {
        String sql = "insert into smp(nome, documento_pdf) values(?, ?)";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, nome);
        ps.setBytes(2, document);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public boolean existsInDatabase() throws SQLException {
        String sql = "select * from smp where nome = ?";
        PreparedStatement ps = DatabaseContext.getPreparedStatement(sql);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + (int) (this.documentSize ^ (this.documentSize >>> 32));
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
        final SMP other = (SMP) obj;
        if (this.documentSize != other.documentSize) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
}
