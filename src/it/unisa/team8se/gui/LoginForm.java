/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import it.unisa.team8se.DatabaseContext;
import it.unisa.team8se.models.Activity;
import it.unisa.team8se.models.Area;
import it.unisa.team8se.models.EWO;
import java.awt.EventQueue;
import static java.lang.System.out;
import java.sql.Connection;

/**
 *
 * @author prgne
 */
public class LoginForm extends javax.swing.JFrame {

    private String url = "jdbc:postgresql://localhost";
    private String user;
    private String pwd;
    private Connection con;

    public LoginForm() {
        initComponents();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        utenteLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        ruoloLabel = new javax.swing.JLabel();
        roleSelector = new javax.swing.JComboBox<>();
        loginButton = new javax.swing.JButton();
        loginMessageLabel = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("Errore");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programma - Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        main.setBackground(new java.awt.Color(255, 198, 139));
        java.awt.GridBagLayout mainLayout = new java.awt.GridBagLayout();
        mainLayout.columnWidths = new int[] {0};
        mainLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        main.setLayout(mainLayout);

        loginLabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("LOGIN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 200;
        main.add(loginLabel, gridBagConstraints);

        utenteLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        utenteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        utenteLabel.setText("UTENTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipady = 10;
        main.add(utenteLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 200;
        main.add(usernameField, gridBagConstraints);

        passwordLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("PASSWORD");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipady = 10;
        main.add(passwordLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 200;
        main.add(passwordField, gridBagConstraints);

        ruoloLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        ruoloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ruoloLabel.setText("RUOLO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.ipady = 10;
        main.add(ruoloLabel, gridBagConstraints);

        roleSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Planner", "Maintainer" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        main.add(roleSelector, gridBagConstraints);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 20;
        main.add(loginButton, gridBagConstraints);

        loginMessageLabel.setForeground(new java.awt.Color(204, 0, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        main.add(loginMessageLabel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String item = (String) roleSelector.getSelectedItem();
        String TEST_PASSWORD = "test";
        String TEST_USERNAME = TEST_PASSWORD;

        user = usernameField.getText();
        pwd = passwordField.getText();

        if (TEST_PASSWORD.equals(pwd) && TEST_USERNAME.equals(user)) {
            
            if ("Maintainer".equals(item)) {
                EventQueue.invokeLater(() -> {
                    new MaintainerForm().setVisible(true);
                });
            }
            if ("Planner".equals(item)) {
                EventQueue.invokeLater(() -> {
                    new PlannerForm().setVisible(true);
                });
            }
            if ("Administrator".equals(item)) {
                EventQueue.invokeLater(() -> {
                    new SystemAdminForm().setVisible(true);
                });
            }
            loginMessageLabel.setText("LOGIN ESEGUITO");
            dispose();
        } else{
            loginMessageLabel.setText("USER O PASSWORD ERRATI");
        }
        usernameField.setText("");
        passwordField.setText("");
    }//GEN-LAST:event_loginButtonActionPerformed
        
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm lf = new LoginForm();
                lf.setVisible(true);
            }
        });

        //CONNESSIONE AL DB
        DatabaseContext.connectDatabase("ProgettoSE","postgres", "password");
        //out.println(Activity.getInstanceWithWeekNumber(32));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel loginMessageLabel;
    private javax.swing.JPanel main;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> roleSelector;
    private javax.swing.JLabel ruoloLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel utenteLabel;
    // End of variables declaration//GEN-END:variables
}
