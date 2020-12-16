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
import it.unisa.team8se.models.SMP;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giuse
 */
public class ActivityManager extends javax.swing.JFrame {

    private DefaultTableModel activityTableModel;
    private DefaultComboBoxModel areaSelectorModel;
    private DefaultComboBoxModel smpSelectorModel;

    private LinkedList<Activity> activities;
    private LinkedList<Area> areas;

    public ActivityManager() {
        if (!DatabaseContext.isConnected()) {
            DatabaseContext.connectDatabase();
        }

        initComponents();

        activities = new LinkedList<>();
        areas = new LinkedList<>();

        areaSelectorModel = new DefaultComboBoxModel();
        smpSelectorModel = new DefaultComboBoxModel();
        
        areaSelector.setModel(areaSelectorModel);
        smpSelector.setModel(smpSelectorModel);

        weekSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = weekSlider.getValue();
                weekSliderValue.setText(Integer.toString(value));
            }
        });

        initTableModel();
        refreshActivities();
        refreshAreas();
        refreshSMPList();
    }

    private void initTableModel() {
        activityTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        activityTableModel.addColumn("ID");
        activityTableModel.addColumn("Filiale");
        activityTableModel.addColumn("Settore");
        activityTableModel.addColumn("Ambito");
        activityTableModel.addColumn("Week number");
        activityTableModel.addColumn("Data e ora");
        activityTableModel.addColumn("EIT (min)");
        activityTableModel.addColumn("Interrompibile");

        activityTable.setModel(activityTableModel);
    }

    protected boolean refreshActivities() {
        activityTableModel.setRowCount(0);
        activities.clear();

        Activity[] as = Activity.getAllDatabaseInstances();
        if (as != null) {
            Collections.addAll(activities, as);
        } else {
            return false;
        }

        for (Activity a : activities) {
            activityTableModel.addRow(a.toArray());
        }
        return true;
    }

    protected void refreshSMPList(){
        smpSelectorModel.removeAllElements();
        SMP[] smps = SMP.getAllDatabaseInstancesInfoOnly();
        if(smps != null){
            for(SMP s : smps){
                smpSelectorModel.addElement(s.getNome());
            }
        }
    }
    
    protected void refreshAreas() {
        areas.clear();
        areaSelectorModel.removeAllElements();

        try {
            Area[] as = Area.getAllDatabaseInstances();
            if (as != null) {
                for (Area a : as) {
                    areas.add(a);
                    areaSelectorModel.addElement(a.toString());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected boolean addActivity(Activity a) {
        try {
            a.saveToDatabase();
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nell'inserimento!");
            return false;
        }
    }

    protected boolean removeActivity(int idActivity) {
        try {
            Activity.getInstanceWithPK(idActivity).removeFromDatabase();
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Rimozione fallita!");
            return false;
        }
    }

    protected boolean modifyActivity(int idActivity, Object newValue, String field) {
        try {
            Activity a = Activity.getInstanceWithPK(idActivity);
            if (field.equalsIgnoreCase("EIT (min)")) {
                a.updateInDatabase(newValue, "ETA");
            } else if (field.equalsIgnoreCase("Filiale")) {
                a.updateInDatabase(newValue, "LUOGO_GEOGRAFICO");
            } else if (field.equalsIgnoreCase("Settore")) {
                a.updateInDatabase(newValue, "AREA");
            } else if (field.equalsIgnoreCase("Data e ora")) {
                a.updateInDatabase(newValue, "DATA_E_ORA");
            } else if (field.equalsIgnoreCase("Week number")) {
                a.updateInDatabase(newValue, "WEEK_NUMBER");
            } else {
                a.updateInDatabase(newValue, field);
            }
            return true;
        } catch (SQLException ex) {
            Message.raiseError(this, "Modifica fallita!");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        activityCreationForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        areaSelector = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        typologyInputField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        weekSliderValue = new javax.swing.JLabel();
        weekSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        eitInputField = new javax.swing.JTextField();
        interruptibleRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        smpSelector = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Activity Manager");
        setIconImage(Message.getImageIcon());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 204, 153));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTIVITY LIST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        activityTable.setAutoCreateRowSorter(true);
        activityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        activityTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        activityTable.setRowSelectionAllowed(false);
        activityTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        activityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activityTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(activityTable);

        modifyButton.setText("Modify");
        modifyButton.setEnabled(false);
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        activityCreationForm.setBackground(new java.awt.Color(255, 204, 153));
        activityCreationForm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREATE ACTIVITY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        activityCreationForm.setLayout(new java.awt.GridLayout(14, 1, 5, 5));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Area");
        jLabel1.setOpaque(true);
        activityCreationForm.add(jLabel1);

        areaSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        activityCreationForm.add(areaSelector);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Typology");
        jLabel4.setOpaque(true);
        activityCreationForm.add(jLabel4);
        activityCreationForm.add(typologyInputField);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("WeekNumber");
        jLabel5.setOpaque(true);
        activityCreationForm.add(jLabel5);

        weekSliderValue.setBackground(new java.awt.Color(51, 51, 51));
        weekSliderValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weekSliderValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weekSliderValue.setLabelFor(weekSlider);
        weekSliderValue.setText("1");
        activityCreationForm.add(weekSliderValue);

        weekSlider.setBackground(new java.awt.Color(255, 204, 153));
        weekSlider.setMaximum(52);
        weekSlider.setMinimum(1);
        weekSlider.setPaintTicks(true);
        weekSlider.setSnapToTicks(true);
        weekSlider.setToolTipText("");
        weekSlider.setValue(1);
        activityCreationForm.add(weekSlider);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estimated Intervention Time (EIT)");
        jLabel3.setOpaque(true);
        activityCreationForm.add(jLabel3);
        activityCreationForm.add(eitInputField);

        interruptibleRadioButton.setBackground(new java.awt.Color(51, 51, 51));
        interruptibleRadioButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        interruptibleRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        interruptibleRadioButton.setSelected(true);
        interruptibleRadioButton.setText("Interruptible");
        activityCreationForm.add(interruptibleRadioButton);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Standard Maintenance Procedure (SMP)");
        jLabel2.setOpaque(true);
        activityCreationForm.add(jLabel2);

        smpSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        activityCreationForm.add(smpSelector);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        activityCreationForm.add(addButton);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(activityCreationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(activityCreationForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(modifyButton)
                    .addComponent(removeButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            UserSession.close();
        } catch (SQLException ex) {
            Message.raiseError(this, "Errore nella chiusura!");
        }
    }//GEN-LAST:event_formWindowClosing

    private void activityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activityTableMouseClicked
        modifyButton.setEnabled(true);
        removeButton.setEnabled(true);
    }//GEN-LAST:event_activityTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            if (areaSelector.getSelectedIndex() < 0) {
                return;
            }

            int id = Activity.getMaxId() + 1;
            int weekNumber = weekSlider.getValue();
            boolean interruptible = interruptibleRadioButton.isSelected();

            Integer eit = Integer.parseInt(eitInputField.getText());
            Area area = areas.get(areaSelector.getSelectedIndex());
            String typology = typologyInputField.getText();
            Timestamp dateTime = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));

            if (typology == null || typology.isEmpty()) {
                return;
            }
            if(eit <= 0){
                Message.raiseError(this, "Activity creation failed: Please insert a positive integer into EIT field.");
                return;
            }

            Activity a = new Activity(id, area, typology, weekNumber, dateTime, eit, interruptible);
            addActivity(a);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Message.raiseError(this, "Inserimento fallito!");
            return;
        }catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
            Message.raiseError(this, "Activity creation failed: Please insert a positive integer into EIT field.");
            return;
        }
        
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
        refreshActivities();
    }//GEN-LAST:event_addButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = activityTable.getSelectedRow();
        int selectedId = Integer.parseInt((String) activityTableModel.getValueAt(selectedRow, 0));
        String selectedField = activityTable.getColumnName(activityTable.getSelectedColumn());
        Object newValue;
        try {
            if (selectedField.equalsIgnoreCase("ID") || selectedField.equalsIgnoreCase("Week number") || selectedField.equalsIgnoreCase("EIT")) {
                newValue = Integer.parseInt(JOptionPane.showInputDialog(this,
                        "Modifica " + selectedField + " dell'attività " + selectedId, "Modifica", JOptionPane.PLAIN_MESSAGE));
            } else if (selectedField.equalsIgnoreCase("Interrompibile")) {
                int reply = JOptionPane.showConfirmDialog(this, "L'attività " + selectedId + " è interrompibile?",
                        "Modifica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                switch (reply) {
                    case JOptionPane.YES_OPTION:
                        newValue = true;
                        break;
                    case JOptionPane.NO_OPTION:
                        newValue = false;
                        break;
                    default:
                        return;
                }
            } else if (selectedField.equalsIgnoreCase("Data e ora")) {
                newValue = Timestamp.valueOf(JOptionPane.showInputDialog(this,
                        "Modifica data e ora dell'attività " + selectedId
                        + "nel seguente formato: yyyy-mm-dd hh:mm", "Modifica", JOptionPane.PLAIN_MESSAGE) + ":00");
            } else {
                newValue = JOptionPane.showInputDialog(this, "Modifica " + selectedField, "Modifica", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            return;
        }
        if (newValue == null || newValue == "") {
            return;
        }
        modifyActivity(selectedId, newValue, selectedField);
        modifyButton.setEnabled(false);
        removeButton.setEnabled(false);
        refreshActivities();
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int selectedRow = activityTable.getSelectedRow();

        if (selectedRow == -1) {
            Message.raiseError(this, "Selezionare una riga!");
            return;
        }

        int selectedId = Integer.parseInt((String) activityTableModel.getValueAt(selectedRow, 0));

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
    private javax.swing.JPanel activityCreationForm;
    private javax.swing.JTable activityTable;
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> areaSelector;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField eitInputField;
    private javax.swing.JRadioButton interruptibleRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JComboBox<String> smpSelector;
    private javax.swing.JTextField typologyInputField;
    private javax.swing.JSlider weekSlider;
    private javax.swing.JLabel weekSliderValue;
    // End of variables declaration//GEN-END:variables
}


/*
            Area[] options = Area.getAllDatabaseInstances();
            Area area = (Area) JOptionPane.showInputDialog(this, "Seleziona area", "Aggiunta",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (area == null) {
                return;
            }
            String ambito = JOptionPane.showInputDialog(this, "Inserisci ambito",
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE);
            if (ambito == null) {
                return;
            }
            int weekNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserisci numero della settimana",
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE));
            Timestamp datetime = Timestamp.valueOf(JOptionPane.showInputDialog(this,
                    "Inserisci data e ora nel seguente formato: yyyy-mm-dd hh:mm", "Aggiunta", JOptionPane.PLAIN_MESSAGE) + ":00");
            int eit = Integer.parseInt(JOptionPane.showInputDialog(this, "Inserisci tempo stimato d'intervento in minuti",
                    "Aggiunta", JOptionPane.PLAIN_MESSAGE));
            int reply = JOptionPane.showConfirmDialog(this, "L'attività " + id + " è interrompibile?",
                    "Aggiunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean interruptible;
            switch (reply) {
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
             */