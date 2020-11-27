/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.MultiPanelManager;
import it.unisa.team8se.gui.datamodels.ActivityTableDataModel;
import it.unisa.team8se.gui.datamodels.MaintainerAvailabilityDataModel;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Area;
import it.unisa.team8se.models.Competence;
import it.unisa.team8se.models.Maintainer;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author cptso
 */
public class PlannerForm extends javax.swing.JFrame {

    /**
     * Creates new form ActivityList
     */
    public PlannerForm() {
        initComponents();
        setupActivityTable();
        setupMaintainerTable();

        panelManager = new MultiPanelManager();
        panelManager.addPanel("ActivityList", activityList);
        panelManager.addPanel("ActivitySummary", activitySummary);
        panelManager.addPanel("MaintainerList", maintainerList);
    }

    private void setupActivityTable() {
        activities = new LinkedList<>();
        Collections.addAll(activities, Activity.getAllDatabaseInstances());
        
        /*
        Activity a0 = new Activity();
        a0.setID(0);
        a0.setTipology("Hydraulic");
        a0.setArea(new Area("fisciano", "plumbing"));
        a0.setEIT(120);
        Activity a1 = new Activity();
        a1.setID(1);
        a1.setTipology("Hydraulic");
        a1.setArea(new Area("fisciano", "plumbing"));
        a1.setEIT(90);
        Activity a2 = new Activity();
        a2.setID(2);
        a2.setTipology("Hydraulic");
        a2.setArea(new Area("fisciano", "plumbing"));
        a2.setEIT(100);
        Activity a3 = new Activity();
        a3.setID(3);
        a3.setTipology("Hydraulic");
        a3.setArea(new Area("fisciano", "plumbing"));
        a3.setEIT(122);

        activities.add(a0);
        activities.add(a1);
        activities.add(a2);
        activities.add(a3);
        */
        
        activityTable.setModel(new ActivityTableDataModel(activities));
        ListSelectionModel selectionModel = activityTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.setValueIsAdjusting(false);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = activityTable.getSelectedRow();
                if (selectedRow >= 0) {
                    System.out.println("Selected index " + selectedRow);
                    activityTableRowSelected(selectedRow);
                    activityTable.clearSelection();
                }
            }
        });
    }
    
    private void setupMaintainerTable(){
        maintainers = new LinkedList<>();
        
        Maintainer m0=new Maintainer("Mannara","Marco","marco","xxx");
        //m0.setName("Marco");
        m0.addCompetence(new Competence (1,"Team Leader"));
        Maintainer m1= new Maintainer("Lambiase","Manuel","manuel","xxx");
        //m1.setName("Manuel");
        m1.addCompetence(new Competence (2,"Problem Solving"));
        Maintainer m2= new Maintainer("Russo","Giuseppe Felice","giuseppe","xxx");
        //m2.setName("Giuseppe");
        m2.addCompetence(new Competence (3,"Lateral Thinking"));
        Maintainer m3= new Maintainer("Landino","Gerardo","gerardo","xxx");
        //m3.setName("Gerardo");
        m3.addCompetence(new Competence (4,"Creativity"));
        
        maintainers.add(m0);
        maintainers.add(m1);
        maintainers.add(m2);
        maintainers.add(m3);
        
        maintainerTable.setModel(new MaintainerAvailabilityDataModel(maintainers));
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

        tabbedPane = new javax.swing.JTabbedPane();
        activityList = new javax.swing.JPanel();
        activityListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        weeklabel = new javax.swing.JLabel();
        weekNumberLabel = new javax.swing.JLabel();
        activitySummary = new javax.swing.JPanel();
        interventionDescScrollPane = new javax.swing.JScrollPane();
        interventionDescText = new javax.swing.JTextPane();
        interventionDescLabel = new javax.swing.JLabel();
        workspaceNotesLabel = new javax.swing.JLabel();
        workspaceNotesScrollPane = new javax.swing.JScrollPane();
        workspaceNotesText = new javax.swing.JTextPane();
        workspaceNotesEditButton = new javax.swing.JButton();
        interventionDescriptionEditButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        maintainerList = new javax.swing.JPanel();
        maintainerScrollPane = new javax.swing.JScrollPane();
        maintainerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPane.setPreferredSize(new java.awt.Dimension(800, 600));

        activityList.setPreferredSize(new java.awt.Dimension(800, 600));
        java.awt.GridBagLayout activityListLayout = new java.awt.GridBagLayout();
        activityListLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0};
        activityListLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0};
        activityList.setLayout(activityListLayout);

        activityListLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        activityListLabel.setText("ACTIVITY LIST");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activityList.add(activityListLabel, gridBagConstraints);

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
        activityTable.setIntercellSpacing(new java.awt.Dimension(2, 1));
        jScrollPane1.setViewportView(activityTable);
        activityTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 757;
        gridBagConstraints.ipady = 400;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activityList.add(jScrollPane1, gridBagConstraints);

        weeklabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weeklabel.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activityList.add(weeklabel, gridBagConstraints);

        weekNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weekNumberLabel.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activityList.add(weekNumberLabel, gridBagConstraints);

        tabbedPane.addTab("ActivityList", activityList);

        activitySummary.setBackground(new java.awt.Color(255, 204, 153));
        java.awt.GridBagLayout activitySummaryLayout = new java.awt.GridBagLayout();
        activitySummaryLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0, 6, 0};
        activitySummaryLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        activitySummary.setLayout(activitySummaryLayout);

        interventionDescScrollPane.setViewportView(interventionDescText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 238;
        gridBagConstraints.ipady = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activitySummary.add(interventionDescScrollPane, gridBagConstraints);

        interventionDescLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        interventionDescLabel.setText("Intervention Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(interventionDescLabel, gridBagConstraints);

        workspaceNotesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        workspaceNotesLabel.setText("WorkSpace Notes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(workspaceNotesLabel, gridBagConstraints);

        workspaceNotesScrollPane.setViewportView(workspaceNotesText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 238;
        gridBagConstraints.ipady = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        activitySummary.add(workspaceNotesScrollPane, gridBagConstraints);

        workspaceNotesEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/edit.png"))); // NOI18N
        workspaceNotesEditButton.setBorder(null);
        workspaceNotesEditButton.setBorderPainted(false);
        workspaceNotesEditButton.setPreferredSize(new java.awt.Dimension(28, 28));
        workspaceNotesEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workspaceNotesEditButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(workspaceNotesEditButton, gridBagConstraints);

        interventionDescriptionEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/edit.png"))); // NOI18N
        interventionDescriptionEditButton.setBorder(null);
        interventionDescriptionEditButton.setBorderPainted(false);
        interventionDescriptionEditButton.setPreferredSize(new java.awt.Dimension(28, 28));
        interventionDescriptionEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interventionDescriptionEditButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(interventionDescriptionEditButton, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ACTIVITY SUMMARY");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        activitySummary.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("10");
        jLabel5.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        activitySummary.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        activitySummary.add(jLabel6, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/unisa/team8se/assets/icons/pdf.png"))); // NOI18N
        jButton1.setOpaque(false);
        jButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 16;
        activitySummary.add(jButton1, gridBagConstraints);

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
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 14;
        activitySummary.add(jScrollPane2, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Activity to assign");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        activitySummary.add(jLabel7, gridBagConstraints);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Carpentry - Fisciano");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        activitySummary.add(jLabel8, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Go to Mantainers");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 20;
        activitySummary.add(jButton2, gridBagConstraints);

        tabbedPane.addTab("ActivitySummary", activitySummary);

        java.awt.GridBagLayout maintainerListLayout = new java.awt.GridBagLayout();
        maintainerListLayout.columnWidths = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0};
        maintainerListLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0};
        maintainerList.setLayout(maintainerListLayout);

        maintainerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        maintainerScrollPane.setViewportView(maintainerTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 752;
        gridBagConstraints.ipady = 474;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        maintainerList.add(maintainerScrollPane, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("MANTAINER LIST");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        maintainerList.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Week n#");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        maintainerList.add(jLabel3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("10");
        jLabel1.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        maintainerList.add(jLabel1, gridBagConstraints);

        tabbedPane.addTab("MaintainerList", maintainerList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void activityTableRowSelected(int index) {
        selectedActivity = activities.get(index);
        tabbedPane.setSelectedIndex(1);
        interventionDescText.setText(selectedActivity.getInterventionDescription());
        
    }

    private void interventionDescriptionEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interventionDescriptionEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interventionDescriptionEditButtonActionPerformed

    private void workspaceNotesEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workspaceNotesEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workspaceNotesEditButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlannerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        PlannerForm pf = new PlannerForm();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activityList;
    private javax.swing.JLabel activityListLabel;
    private javax.swing.JPanel activitySummary;
    private javax.swing.JTable activityTable;
    private javax.swing.JLabel interventionDescLabel;
    private javax.swing.JScrollPane interventionDescScrollPane;
    private javax.swing.JTextPane interventionDescText;
    private javax.swing.JButton interventionDescriptionEditButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel maintainerList;
    private javax.swing.JScrollPane maintainerScrollPane;
    private javax.swing.JTable maintainerTable;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel weekNumberLabel;
    private javax.swing.JLabel weeklabel;
    private javax.swing.JButton workspaceNotesEditButton;
    private javax.swing.JLabel workspaceNotesLabel;
    private javax.swing.JScrollPane workspaceNotesScrollPane;
    private javax.swing.JTextPane workspaceNotesText;
    // End of variables declaration//GEN-END:variables

    private LinkedList<Activity> activities;
    private LinkedList<Maintainer> maintainers;
    private Activity selectedActivity;
    
    private MultiPanelManager panelManager;
}
