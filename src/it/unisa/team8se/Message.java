/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author giuse
 */
public class Message {
    public Message() {
        
    }
    
    public static void raiseError(Component parentComponent, String message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(parentComponent, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }
}
