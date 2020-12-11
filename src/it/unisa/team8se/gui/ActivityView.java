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
import it.unisa.team8se.models.Competence;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author giuse
 */
public class ActivityView extends javax.swing.JFrame {

    private DefaultComboBoxModel<Integer> comboBoxModel;
    private DefaultListModel<String> listModel;
    private LinkedList<Activity> activities;
    private int defaultId;

    /**
     * Creates new form TaskView
     */
    public ActivityView(int defaultId) {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        activities = new LinkedList<>();
        initComboBoxModel();
        refreshActivities();
        int defaultActivity = initListModel();
        initComponents();
        refreshCompetences(defaultActivity);
    }

    private void initComboBoxModel() {
        comboBoxModel = new DefaultComboBoxModel();
    }

    protected int initListModel() {
        listModel = new DefaultListModel<>();
        if (comboBoxModel.getSize() != 0) {
            return (int) comboBoxModel.getElementAt(0);
        }
        return -1;
    }

    protected void refreshActivities() {
        comboBoxModel.removeAllElements();
        Activity[] as = Activity.getAllDatabaseInstances();
        if (as != null && as.length > 0) {
            activities.clear();
            for (Activity a : as) {
                comboBoxModel.addElement(a.getID());
                activities.add(a);
            }
        }
    }

    private void setLabels(Activity a) {
        areaLabel.setText(a.getArea().toString());
        typologyLabel.setText(a.getTipology());
        eitLabel.setText(String.valueOf(a.getEIT()));
    }

    protected void refreshCompetences(int id) {
        listModel.clear();
        Activity activity = Activity.getInstanceWithPK(id);
        setLabels(activity);
        activity.getRequiredCompetencesFromDatabase();
        for (Competence c : activity.getRequiredCompetences()) {
            listModel.addElement(c.getDescrizione());
        }
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
        backButton = new javax.swing.JButton();
        activityComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        competenceList = new javax.swing.JList<>();
        assignButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        typologyLabel = new javax.swing.JLabel();
        eitLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Activity View");
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        backButton.setText("Indietro");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        activityComboBox.setModel(comboBoxModel);
        activityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityComboBoxActionPerformed(evt);
            }
        });

        competenceList.setModel(listModel);
        jScrollPane1.setViewportView(competenceList);

        assignButton.setText("Assegna");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Rimuovi");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID attività");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Competenze richieste");

        areaLabel.setText("###############");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Area");

        typologyLabel.setText("##########");

        eitLabel.setText("####");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tipologia");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("EIT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(activityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(areaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel3))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(assignButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(typologyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(eitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaLabel)
                    .addComponent(typologyLabel)
                    .addComponent(eitLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(removeButton)
                    .addComponent(assignButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
            DatabaseContext.closeConnection();
            System.exit(0);
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        String role = UserSession.getLoggedUser().getRole();
        UserBaseForm form;
        if (role.equalsIgnoreCase("planner")) {
            form = new PlannerForm();
        } else {
            form = new SystemAdminForm();
        }
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void activityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityComboBoxActionPerformed
        int selectedId = (int) activityComboBox.getSelectedItem();
        refreshCompetences(selectedId);
        Activity selectedActivity = Activity.getInstanceWithPK(selectedId);
        setLabels(selectedActivity);
    }//GEN-LAST:event_activityComboBoxActionPerformed

    private Activity getSelectedActivity() {
        if (comboBoxModel.getSize() == 0) {
            Message.raiseError(this, "Non c'è alcun'attività!");
            return null;
        }
        int index = activityComboBox.getSelectedIndex();

        if (index < 0 || index > activities.size()) {
            return activities.get(0);
        } else {
            return activities.get(index);
        }
    }

    private String getSelectedCompetence() {
        if (listModel.getSize() == 0) {
            Message.raiseError(this, "Non c'è alcuna competenza!");
            return null;
        }
        String selectedCompetence = competenceList.getSelectedValue();
        if (selectedCompetence == null) {
            Message.raiseError(this, "Non è stata selezionata alcuna competenza!");
            return null;
        }
        return selectedCompetence;
    }

    protected boolean assignCompetence(int id, String competenceDesc) {
        if(id < 0 || competenceDesc.equals(""))
            return false;
        
        try {            
            Competence competence = Competence.saveToDatabaseWithDescription(competenceDesc);
            competence.saveIntoRequisito(id);            
        } catch (SQLException ex) {
            Message.raiseError(this,"Errore nell'assegnamento");
            return false;
        }
        refreshCompetences(id);
        return true;
    }

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        Activity selectedActivity = getSelectedActivity();
        if(selectedActivity == null)
            return;
        int selectedId = selectedActivity.getID();
        String competence = JOptionPane.showInputDialog(this, "Assegna una competenza all'attività "+
                String.valueOf(selectedId), "Assegnazione", JOptionPane.PLAIN_MESSAGE);
        if(competence == null || competence.equals(""))
            return;
        assignCompetence(selectedId, competence);
    }//GEN-LAST:event_assignButtonActionPerformed

    protected boolean removeCompetence(int id, String description) {
        try {
            Competence.removeFromRequisitoWithDescription(description, id);
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella rimozione!");
            return false;
        }
        refreshCompetences(id);
        return true;
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Activity selectedActivity = getSelectedActivity();
        String competence = getSelectedCompetence();
        if(selectedActivity == null || competence == null)
            return;
        
        int selectedId = selectedActivity.getID();
        
        int reply = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler cancellare la competenza '"+
                competence+"'?", "Rimozione", JOptionPane.YES_NO_OPTION);
        if(reply==JOptionPane.YES_OPTION)
            removeCompetence(selectedId, competence);
    }//GEN-LAST:event_removeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivityView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Integer> activityComboBox;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton assignButton;
    private javax.swing.JButton backButton;
    private javax.swing.JList<String> competenceList;
    private javax.swing.JLabel eitLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel typologyLabel;
    // End of variables declaration//GEN-END:variables
}
