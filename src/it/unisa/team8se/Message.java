/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import it.unisa.team8se.gui.PlannerForm;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author giuse
 */
public class Message {

    public Message() {

    }

    public static void raiseInfo(Component parentComponent, String message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(parentComponent, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void raiseError(Component parentComponent, String message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(parentComponent, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public static Image getImageIcon() {
        ImageIcon icon = new ImageIcon("\\Users\\icon.png");
        return icon.getImage();
    }
}
