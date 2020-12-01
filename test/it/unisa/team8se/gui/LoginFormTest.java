/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se.gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giuse
 */
public class LoginFormTest {
    private LoginForm form;
    
    public LoginFormTest() {
    }

    @Before
    public void setUp() {
        form = new LoginForm();
    }
    
    @After
    public void tearDown() {
        form = null;
    }
}
