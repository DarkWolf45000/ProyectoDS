/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import singleton.Local;

/**
 *
 * @author LuisEduardo
 */
public class GerenteTest {
    
    public GerenteTest() {
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
     * Test of getLocal method, of class Gerente.
     */
    
    @Test
    public void testObteneridLocal() {
        System.out.println("obteneridLocal");
        BD bdtest = new BD();
        bdtest.getConexion();
        Gerente instance = new Gerente("lsalazar","espol2","gerente",bdtest,"0920920920","Luis","Salazar");
        int result = instance.obteneridLocal();
        assertEquals(1, result);
    }
    
}
