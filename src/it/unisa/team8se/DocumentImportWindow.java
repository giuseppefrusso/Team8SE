/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author cptso
 */
public class DocumentImportWindow{
   
    public static File importDocument(Component parent){
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Document (*.pdf)", "pdf");
        fc.setFileFilter(filter);

        int res = fc.showDialog(parent, "Load");
        if (res == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String fileName = f.getName();
            String fileExtension = fileName.substring(fileName.length() - 4, fileName.length());

            if (f.getAbsolutePath() == null || !fileExtension.equals(".pdf") || f.isDirectory()) {
                Message.raiseError(parent, "Per favore seleziona un file di tipo PDF.");
                return null;
            }
            return f;
        }
        return null;
    }
}
