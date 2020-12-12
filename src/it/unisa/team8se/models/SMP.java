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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cptso
 */
public class SMP extends DatabaseModel {

    private String nome;
    //private String documentoPDF;
    private byte[] document;
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
    }

    public void importDocument(String filePath, String fileName) throws IOException {
        importDocument(filePath + fileName + ".pdf");
    }

    public void exportDocument(String filePath, String fileName) {
        try {
            Path path = Paths.get(filePath + fileName + ".pdf");
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
                Desktop.getDesktop().open(new File(path.toUri()));
            } catch (IOException ex) {
                Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return true;
        }
        return false;
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
            if (list != null) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void getFromResultSet(ResultSet rs) throws SQLException {
        setNome(rs.getString("nome"));
        document = rs.getBytes("documento_pdf");
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
}
