/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author cptso
 */
public class MultiPanelManager {
    
    private HashMap<String,JPanel> panels;
    private JPanel shownPanel;

    public MultiPanelManager() {
        panels = new HashMap<>();
    }
    
    public void addPanel(String key,JPanel panel){
        panel.setVisible(false);
        panels.put(key,panel);
    }
    
    public void showPanel(String key){
        JPanel panel = panels.get(key);
        if(panel != null){
            panel.setVisible(true);
        }
    }
}
