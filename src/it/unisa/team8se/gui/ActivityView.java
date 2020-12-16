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
import it.unisa.team8se.models.Material;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author giuse
 */
public class ActivityView extends javax.swing.JFrame {

    private DefaultComboBoxModel<Integer> comboBoxModel;
    private DefaultListModel<String> competenceModel, materialModel;
    private LinkedList<Activity> activities;
    private int defaultId;

    /**
     * Creates new form TaskView
     *
     * @param defaultId
     */
    public ActivityView(int defaultId) {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }
        activities = new LinkedList<>();
        initComboBoxModel();
        refreshActivities();
        int firstId = initListModels();
        initComponents();
        this.defaultId = defaultId;
        if (defaultId != -1) {
            activityComboBox.setEnabled(false);
        } else {
            defaultId = firstId;
        }
        refreshCompetencesAndMaterials(defaultId);
    }

    private void initComboBoxModel() {
        comboBoxModel = new DefaultComboBoxModel();
    }

    protected int initListModels() {
        competenceModel = new DefaultListModel<>();
        materialModel = new DefaultListModel<>();
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

    private void refreshCompetencesAndMaterials(int id) {
        Activity activity = Activity.getInstanceWithPK(id);
        setLabels(activity);
        refreshCompetences(activity);
        refreshMaterials(activity);
    }

    private void refreshCompetences(Activity activity) {
        competenceModel.clear();
        try {
            for (Competence c : activity.getRequiredCompetencesFromDatabase()) {
                competenceModel.addElement(c.getDescrizione());
            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Loading error of competences!");
        }
    }

    private void refreshMaterials(Activity activity) {
        materialModel.clear();
        try {
            for (Material m : activity.getUsedMaterialsFromDatabase()) {
                materialModel.addElement(m.getName());
            }
        } catch (SQLException ex) {
            Message.raiseError(this, "Loading error of materials!");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        activityComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        materialList = new javax.swing.JList<>();
        assignCompetenceButton = new javax.swing.JButton();
        removeCompetenceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        typologyLabel = new javax.swing.JLabel();
        eitLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        competenceList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        assignMaterialButton = new javax.swing.JButton();
        removeMaterialButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Activity View");
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        backButton.setText("Back");
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

        materialList.setModel(materialModel);
        materialList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                materialListFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(materialList);

        assignCompetenceButton.setText("Assign");
        assignCompetenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignCompetenceButtonActionPerformed(evt);
            }
        });

        removeCompetenceButton.setText("Remove");
        removeCompetenceButton.setEnabled(false);
        removeCompetenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompetenceButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Activity ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Required competences");

        areaLabel.setText("###############");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Area");

        typologyLabel.setText("##########");

        eitLabel.setText("####");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tipology");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("EIT");

        competenceList.setModel(competenceModel);
        competenceList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                competenceListFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(competenceList);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Used materials");

        assignMaterialButton.setText("Assign");
        assignMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignMaterialButtonActionPerformed(evt);
            }
        });

        removeMaterialButton.setText("Remove");
        removeMaterialButton.setEnabled(false);
        removeMaterialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMaterialButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(typologyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(eitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(backButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(assignCompetenceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeCompetenceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(assignMaterialButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(removeMaterialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assignCompetenceButton)
                    .addComponent(removeCompetenceButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(assignMaterialButton)
                        .addComponent(removeMaterialButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(backButton)
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

    }//GEN-LAST:event_formWindowClosing

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        /*
        String role = UserSession.getLoggedUser().getRole();
        UserBaseForm form;
        if (role.equalsIgnoreCase("planner")) {
            form = new PlannerForm(this.defaultId);
            form.setVisible(true);
            this.setVisible(false);
        } else {
            form = new SystemAdminForm();
        }
        form.setVisible(true);
        this.setVisible(false);*/
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void activityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityComboBoxActionPerformed
        int selectedId = (int) activityComboBox.getSelectedItem();
        refreshCompetencesAndMaterials(selectedId);
        Activity selectedActivity = Activity.getInstanceWithPK(selectedId);
        setLabels(selectedActivity);
    }//GEN-LAST:event_activityComboBoxActionPerformed

    private Activity getSelectedActivity() {
        if (comboBoxModel.getSize() == 0) {
            Message.raiseError(this, "There aren't any activity!");
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
        if (competenceModel.getSize() == 0) {
            Message.raiseError(this, "There isn't any competence!");
            return null;
        }
        String selectedCompetence = competenceList.getSelectedValue();
        if (selectedCompetence == null) {
            Message.raiseError(this, "There isn't any selected competence!");
            return null;
        }
        return selectedCompetence;
    }

    private String getSelectedMaterial() {
        if (materialModel.getSize() == 0) {
            Message.raiseError(this, "There isn't any material!");
            return null;
        }
        String selectedMaterial = materialList.getSelectedValue();
        if (selectedMaterial == null) {
            Message.raiseError(this, "There isn't any selected material!");
            return null;
        }
        return selectedMaterial;
    }

    protected boolean assignCompetence(Activity activity, Competence competence) {
        try {
            //Competence competence = Competence.saveToDatabaseWithDescription(competenceDesc);
            competence.saveIntoRequisite(activity.getID());
        } catch (SQLException ex) {
            Message.raiseError(this, "Assignment error");
            return false;
        }
        refreshCompetences(activity);
        return true;
    }

    private void assignCompetenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignCompetenceButtonActionPerformed
        Activity selectedActivity = getSelectedActivity();
        if (selectedActivity == null) {
            return;
        }

        /*String competence = JOptionPane.showInputDialog(this, "Assegna una competenza all'attività "
                + String.valueOf(selectedActivity.getID()), "Assegnazione", JOptionPane.PLAIN_MESSAGE);*/
        Competence[] cs =Competence.getAllDatabaseInstances();
        Competence competence = (Competence) JOptionPane.showInputDialog(this,"Select a competence","Added", 
                JOptionPane.QUESTION_MESSAGE, null, cs, cs[0]);
        if (competence == null) {
            return;
        }
        assignCompetence(selectedActivity, competence);
        refreshCompetences(selectedActivity);
        removeCompetenceButton.setEnabled(false);
        removeMaterialButton.setEnabled(false);
        competenceList.clearSelection();
    }//GEN-LAST:event_assignCompetenceButtonActionPerformed

    protected boolean removeCompetence(Activity activity, String description) {
        try {
            Competence.removeFromRequisiteWithDescription(description, activity.getID());
        } catch (SQLException ex) {
            Message.raiseError(this, "Removal error!");
            return false;
        }
        return true;
    }

    private void removeCompetenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCompetenceButtonActionPerformed
        Activity selectedActivity = getSelectedActivity();
        String competence = getSelectedCompetence();
        if (selectedActivity == null || competence == null) {
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete that competence? '"
                + competence + "'?", "Discharge", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            removeCompetence(selectedActivity, competence);
            refreshCompetences(selectedActivity);
        }
        removeCompetenceButton.setEnabled(false);
        removeMaterialButton.setEnabled(false);
        competenceList.clearSelection();
    }//GEN-LAST:event_removeCompetenceButtonActionPerformed

    protected boolean assignMaterial(Activity activity, Material material) {
        try {
            material.saveIntoUse(activity.getID());
        } catch (SQLException ex) {
            Message.raiseError(this, "Assignment error!");
            return false;
        }
        return true;
    }

    private void assignMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignMaterialButtonActionPerformed
        Activity selectedActivity = getSelectedActivity();
        if (selectedActivity == null) {
            return;
        }
        Material[] ms = Material.getAllDatabaseInstances();
        Material material = (Material) JOptionPane.showInputDialog(this,"Select a material","Added", 
                JOptionPane.QUESTION_MESSAGE, null, ms, ms[0]);
        if (material == null) {
            return;
        }
        assignMaterial(selectedActivity, material);
        refreshMaterials(selectedActivity);
        removeCompetenceButton.setEnabled(false);
        removeMaterialButton.setEnabled(false);
        materialList.clearSelection();
    }//GEN-LAST:event_assignMaterialButtonActionPerformed

    protected boolean removeMaterial(Activity activity, String nome) {
        try {
            Material material = Material.getInstanceWithPK(nome);
            if (material == null) {
                return false;
            }
            material.removeFromUse(activity.getID());
        } catch (SQLException ex) {
            Message.raiseError(this, "Removal error!");
            return false;
        }
        return true;
    }

    private void removeMaterialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMaterialButtonActionPerformed
        Activity selectedActivity = getSelectedActivity();
        String material = getSelectedMaterial();
        if (selectedActivity == null || material == null) {
            return;
        }

        int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete that material '"
                + material + "'?", "Discharge", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            removeMaterial(selectedActivity, material);
            refreshMaterials(selectedActivity);
        }
        removeCompetenceButton.setEnabled(false);
        removeMaterialButton.setEnabled(false);
        materialList.clearSelection();
    }//GEN-LAST:event_removeMaterialButtonActionPerformed

    private void competenceListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_competenceListFocusGained
        removeCompetenceButton.setEnabled(true);
        removeMaterialButton.setEnabled(false);
        materialList.clearSelection();
    }//GEN-LAST:event_competenceListFocusGained

    private void materialListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_materialListFocusGained
        removeMaterialButton.setEnabled(true);
        removeCompetenceButton.setEnabled(false);
        competenceList.clearSelection();
    }//GEN-LAST:event_materialListFocusGained

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
                new ActivityView(-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Integer> activityComboBox;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton assignCompetenceButton;
    private javax.swing.JButton assignMaterialButton;
    private javax.swing.JButton backButton;
    private javax.swing.JList<String> competenceList;
    private javax.swing.JLabel eitLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> materialList;
    private javax.swing.JButton removeCompetenceButton;
    private javax.swing.JButton removeMaterialButton;
    private javax.swing.JLabel typologyLabel;
    // End of variables declaration//GEN-END:variables
}
