/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisEduardo
 */
public class ControlLogInTest {
    
    public ControlLogInTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

        /**
     * Test of verificar method, of class ControlLogIn.
     */
    @Test
    public void testVerificar() {
        System.out.println("verificar");
        String usuario = "lsalazar3";
        String contra = "espol2";
        ControlLogIn instance = new ControlLogIn();
        boolean result = instance.verificar(usuario, contra);
        assertFalse(result);
        
    }
    
    @Test
    public void testObtenerGerente() throws Exception {
        System.out.println("obtenerGerente");
        String usuario = "lsalazar";
        String contra = "espol2";
        ControlLogIn instance = new ControlLogIn();
        User result = instance.obtenerGerente(usuario, contra);
        assertNotNull(result);
    }


    @Test
    public void testObtenerJefeBodega() throws Exception {
        System.out.println("obtenerJefeBodega");
        String usuario = "lpod";
        String contra = "espol4";
        ControlLogIn instance = new ControlLogIn();
        User result = instance.obtenerJefeBodega(usuario, contra);
        assertNotNull(result);
    }

   
    
}

    

