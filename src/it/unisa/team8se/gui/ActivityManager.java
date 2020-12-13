/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.Message;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Area;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giuse
 */
public class ActivityManager extends javax.swing.JFrame {

    private DefaultTableModel model;
    private LinkedList<Activity> activities;
    
    /**
     * Creates new form ActivityManager
     */
    public ActivityManager() {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        activities = new LinkedList<>();
        initTableModel();
        refreshActivities();
        initComponents();
    }

    private void initTableModel() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //model.addColumn("Tipologia");
        model.addColumn("ID");
        model.addColumn("Filiale");
        model.addColumn("Settore");
        model.addColumn("Ambito");
        model.addColumn("Week number");
        model.addColumn("Data e ora");
        model.addColumn("EIT (min)");
        model.addColumn("Interrompibile");
    }
    
    protected boolean refreshActivities() {
        model.setRowCount(0);
        activities.clear();
        
        Activity[] as = Activity.getAllDatabaseInstances();
        if(as != null) {
            Collections.addAll(activities, as);
        }else
            return false;
        
        for(Activity a: activities) {
            model.addRow(a.toArray());
        }
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Activity Manager");
        setIconImage(Message.getImageIcon());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        activityTable.setAutoCreateRowSorter(true);
        activityTable.setModel(model);
        activityTable.setRowSelectionAllowed(false);
        activityTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        activityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activityTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(activityTable);

        addButton.setText("Aggiungi");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modifica");
        modifyButton.setEnabled(false);
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Rimuovi");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Indietro");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(modifyButton)
                    .addComponent(removeButton)
                    .addComponent(backButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
            DatabaseContext.closeConnection();
            System.exit(0);
        } catch (SQLException ex) {
            Message.raiseError(this,"Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void activityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activityTableMouseClicked
        modifyButton.setEnabled(true);
        removeButton.setEnabled(true);
    }//GEN-LAST:event_activityTableMouseClicked

    protected boolean addActivity(Activity a) {
        try {
            a.saveToDatabase();
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nell'inserimento!");
            return false;
        }       
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try{
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserisci ID", 
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE));
            if(Activity.getInstanceWithPK(id)!=null){
                Message.raiseError(this,"Attività già presente!");
                return;
            }
            Area[] options = Area.getAllDatabaseInstances();
            int indexArea = JOptionPane.showOptionDialog(this, "Scegli area", "Aggiunta", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            Area area = options[indexArea];
            String ambito = JOptionPane.showInputDialog(this, "Inserisci ambito", 
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE);
            int weekNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserisci numero della settimana", 
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE));
            Timestamp datetime = Timestamp.valueOf(JOptionPane.showInputDialog(this, 
                    "Inserisci data e ora nel seguente formato: yyyy-mm-dd hh:mm", "Aggiunta", JOptionPane.PLAIN_MESSAGE)+":00");
            int eit = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserisci tempo stimato d'intervento in minuti", 
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE));
            int reply = JOptionPane.showConfirmDialog(this, "L'attività "+id+" è interrompibile?",
                    "Aggiunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean interruptible;
            switch(reply) {
                case JOptionPane.YES_OPTION:
                    interruptible = true;
                    break;
                case JOptionPane.NO_OPTION:
                    interruptible = false;
                    break;
                default:
                    Message.raiseError(this, "Inserimento non completato!");
                    return;
            }       
                Activity a = new Activity(id, area, ambito, weekNumber, datetime, eit, interruptible);
                addActivity(a);
                   
        }catch(SQLException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            Message.raiseError(this, "Inserimento fallito!");
            return;
        }
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
        refreshActivities();
    }//GEN-LAST:event_addButtonActionPerformed

    protected boolean modifyActivity(int idActivity, Object newValue, String field) {
        try{
            Activity a = Activity.getInstanceWithPK(idActivity);
            if(field.equalsIgnoreCase("EIT (min)")) {
                a.updateInDatabase(newValue, "ETA");
            }else if(field.equalsIgnoreCase("Filiale")) {
                a.updateInDatabase(newValue, "LUOGO_GEOGRAFICO");
            }else if(field.equalsIgnoreCase("Settore")) {
                a.updateInDatabase(newValue, "AREA");
            }else if(field.equalsIgnoreCase("Data e ora")) {
                a.updateInDatabase(newValue, "DATA_E_ORA");
            }else if(field.equalsIgnoreCase("Week number")) {
                a.updateInDatabase(newValue, "WEEK_NUMBER");
            }else {
                a.updateInDatabase(newValue, field);
            }          
            return true;
        }catch(SQLException ex) {
            Message.raiseError(this, "Modifica fallita!");
            return false;
        }
    }
    
    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = activityTable.getSelectedRow();
        int selectedId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));
        String selectedField = activityTable.getColumnName(activityTable.getSelectedColumn());
        Object newValue;
        try{
        if(selectedField.equalsIgnoreCase("ID") || selectedField.equalsIgnoreCase("Week number") || selectedField.equalsIgnoreCase("EIT")) {
            newValue = Integer.parseInt(JOptionPane.showInputDialog(this, 
                    "Modifica "+selectedField+" dell'attività "+selectedId,"Modifica", JOptionPane.PLAIN_MESSAGE));
        }else if(selectedField.equalsIgnoreCase("Interrompibile")) {
            int reply = JOptionPane.showConfirmDialog(this, "L'attività "+selectedId+" è interrompibile?",
                    "Modifica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch(reply) {
                case JOptionPane.YES_OPTION:
                    newValue = true;
                    break;
                case JOptionPane.NO_OPTION:
                    newValue = false;
                    break;
                default:
                    return;
            }     
        } else if(selectedField.equalsIgnoreCase("Data e ora")) {
           newValue = Timestamp.valueOf(JOptionPane.showInputDialog(this, 
                    "Modifica data e ora dell'attività "+selectedId+
                            "nel seguente formato: yyyy-mm-dd hh:mm", "Modifica", JOptionPane.PLAIN_MESSAGE)+":00");
        }else{
            newValue = JOptionPane.showInputDialog(this, "Modifica "+selectedField,"Modifica",JOptionPane.PLAIN_MESSAGE);
        }}catch(IllegalArgumentException ex) {
            return;
        }
        if(newValue == null || newValue == "") {
            return;
        }
        modifyActivity(selectedId,newValue,selectedField);
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
        refreshActivities();
    }//GEN-LAST:event_modifyButtonActionPerformed

    protected boolean removeActivity(int idActivity) {
        try {
            Activity.getInstanceWithPK(idActivity).removeFromDatabase();
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Rimozione fallita!");
            return false;
        }
    }
    
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRow = activityTable.getSelectedRow();

        if (selectedRow == -1) {
            Message.raiseError(this, "Selezionare una riga!");
            return;
        }

        int selectedId = Integer.parseInt((String) model.getValueAt(selectedRow, 0));

        int reply = JOptionPane.showConfirmDialog(this, "Sei sicuro di rimuovere l'attività " + selectedId + "?", "Rimozione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            removeActivity(selectedId);
        }
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
        refreshActivities();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        PlannerForm form = new PlannerForm(-1);
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivityManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivityManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activityTable;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
