/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.Message;
import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.UserSession;
import it.unisa.team8se.gui.datamodels.ActivityTableDataModel;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author cptso
 */
public class MaintainerForm extends javax.swing.JFrame {

    /**
     * Creates new form MaintainerForm
     */
    public MaintainerForm() {

        if(!DatabaseContext.isConnected()){
            DatabaseContext.connectDatabase();
        }
        
        initComponents();
        setupActivityTable();

        tabbedPane.setSelectedIndex(0);
        switchToActivityList();
    }

    private void setupActivityTable() {
        activities = new LinkedList<>();
        refreshActivities();
        activityTable.setModel(new ActivityTableDataModel(activities));
        ListSelectionModel selectionModel = activityTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.setValueIsAdjusting(true);
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            int selectedRow = activityTable.getSelectedRow();
            if (selectedRow >= 0) {
                activityTableRowSelected(selectedRow);
                activityTable.clearSelection();
            }
        });
    }

    private void activityTableRowSelected(int index) {
        selectedActivity = activities.get(index);
        tabbedPane.setSelectedIndex(1);
    }

    private void refreshActivities() {
        activities.clear();
        Activity[] a = Activity.getInstancesAssignedToMaintainer((Maintainer) UserSession.getLoggedUser());
        if (a != null) {
            Collections.addAll(activities, a);
        }
    }

    private void switchToActivityList() {
        tabbedPane.setEnabledAt(1, false);
        selectedActivity = null;
    }

    private void switchToActivitySummary() {
        tabbedPane.setEnabledAt(1, true);

        selectedActivity.getRequiredCompetenciesFromDatabase();
        
        weekNumberLabel.setText(Integer.toString(selectedActivity.getWeekNumber()));
        areaLabel.setText(selectedActivity.getArea().toString());
        interventionDescText.setText(selectedActivity.getInterventionDescription());
        workspaceNotesText.setText(selectedActivity.getWorkspaceNotes());
        
        StringBuilder sb = new StringBuilder();
        for(Competence c : selectedActivity.getRequiredCompetencies()){
            sb.append("-");
            sb.append(c.getDescrizione());
            sb.append("\n");
        }
        requiredCompetenciesText.setText(sb.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tabbedPane = new javax.swing.JTabbedPane();
        activityListPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        listWeekNumberLabel = new javax.swing.JLabel();
        activitySummaryPanel = new javax.swing.JPanel();
        activitySummary = new javax.swing.JPanel();
        interventionDescScrollPane = new javax.swing.JScrollPane();
        interventionDescText = new javax.swing.JTextPane();
        interventionDescLabel = new javax.swing.JLabel();
        workspaceNotesLabel = new javax.swing.JLabel();
        workspaceNotesScrollPane = new javax.swing.JScrollPane();
        workspaceNotesText = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        weekNumberLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        smpButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        requiredCompetenciesText = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Maintainer View");
        setBackground(new java.awt.Color(255, 204, 153));
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        activityListPanel.setBackground(new java.awt.Color(255, 204, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("ACTIVITY LIST");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Week n#");

        activityTable.setAutoCreateRowSorter(true);
        activityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        activityTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(activityTable);

        listWeekNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listWeekNumberLabel.setText("10");

        javax.swing.GroupLayout activityListPanelLayout = new javax.swing.GroupLayout(activityListPanel);
        activityListPanel.setLayout(activityListPanelLayout);
        activityListPanelLayout.setHorizontalGroup(
            activityListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
            .addGroup(activityListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(activityListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(activityListPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listWeekNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        activityListPanelLayout.setVerticalGroup(
            activityListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activityListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(activityListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(listWeekNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Activity List", activityListPanel);

        activitySummary.setBackground(new java.awt.Color(255, 204, 153));
        java.awt.GridBagLayout activitySummaryLayout = new java.awt.GridBagLayout();
        activitySummaryLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        activitySummaryLayout.rowHeights = new int[] {0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0, 8, 0};
        activitySummary.setLayout(activitySummaryLayout);

        interventionDescScrollPane.setViewportView(interventionDescText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activitySummary.add(interventionDescScrollPane, gridBagConstraints);

        interventionDescLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        interventionDescLabel.setText("Intervention Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(interventionDescLabel, gridBagConstraints);

        workspaceNotesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        workspaceNotesLabel.setText("WorkSpace Notes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(workspaceNotesLabel, gridBagConstraints);

        workspaceNotesScrollPane.setViewportView(workspaceNotesText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activitySummary.add(workspaceNotesScrollPane, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ACTIVITY SUMMARY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        activitySummary.add(jLabel4, gridBagConstraints);

        weekNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weekNumberLabel.setText("10");
        weekNumberLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        activitySummary.add(weekNumberLabel, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(jLabel6, gridBagConstraints);

        smpButton.setBackground(new java.awt.Color(255, 255, 255));
        smpButton.setForeground(new java.awt.Color(255, 255, 255));
        smpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/pdf.png"))); // NOI18N
        smpButton.setOpaque(false);
        smpButton.setPreferredSize(new java.awt.Dimension(70, 70));
        smpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 18;
        activitySummary.add(smpButton, gridBagConstraints);

        jScrollPane2.setEnabled(false);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setRequestFocusEnabled(false);
        jScrollPane2.setWheelScrollingEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(10);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setText("Standard Mainteinance \nProcedure ");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 16;
        activitySummary.add(jScrollPane2, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Activity to receive");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        activitySummary.add(jLabel7, gridBagConstraints);

        areaLabel.setBackground(new java.awt.Color(204, 204, 204));
        areaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaLabel.setText("Carpentry - Fisciano");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        activitySummary.add(areaLabel, gridBagConstraints);

        requiredCompetenciesText.setEditable(false);
        requiredCompetenciesText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(requiredCompetenciesText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(jScrollPane4, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Required Competencies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        activitySummary.add(jLabel3, gridBagConstraints);

        javax.swing.GroupLayout activitySummaryPanelLayout = new javax.swing.GroupLayout(activitySummaryPanel);
        activitySummaryPanel.setLayout(activitySummaryPanelLayout);
        activitySummaryPanelLayout.setHorizontalGroup(
            activitySummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
            .addGroup(activitySummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(activitySummaryPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(activitySummary, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        activitySummaryPanelLayout.setVerticalGroup(
            activitySummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(activitySummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(activitySummaryPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(activitySummary, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane.addTab("Activity Summary", activitySummaryPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(tabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneStateChanged
        int index = tabbedPane.getSelectedIndex();
        if (tabbedPane.getTabCount() == 2) {
            if (index == 0) {
                switchToActivityList();
            } else if (index == 1) {
                switchToActivitySummary();
            }
        }
    }//GEN-LAST:event_tabbedPaneStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
            DatabaseContext.closeConnection();
            System.exit(0);
        } catch (SQLException ex) {
            Message.raiseError(this,"Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void smpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smpButtonActionPerformed
         try {
            if (!selectedActivity.openSMPFromDatabase())
                Message.raiseError(this,"SMP non definito!");
        } catch (SQLException ex) {
            Message.raiseError(this,"Errore nel caricamento dal database!");
        } catch (IOException | IllegalArgumentException ex) {
            Message.raiseError(this,"File non trovato!");
        }
    }//GEN-LAST:event_smpButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MaintainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintainerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaintainerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activityListPanel;
    private javax.swing.JPanel activitySummary;
    private javax.swing.JPanel activitySummaryPanel;
    private javax.swing.JTable activityTable;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel interventionDescLabel;
    private javax.swing.JScrollPane interventionDescScrollPane;
    private javax.swing.JTextPane interventionDescText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel listWeekNumberLabel;
    private javax.swing.JTextPane requiredCompetenciesText;
    private javax.swing.JButton smpButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel weekNumberLabel;
    private javax.swing.JLabel workspaceNotesLabel;
    private javax.swing.JScrollPane workspaceNotesScrollPane;
    private javax.swing.JTextPane workspaceNotesText;
    // End of variables declaration//GEN-END:variables
private Activity selectedActivity;
    private LinkedList<Activity> activities;
}
