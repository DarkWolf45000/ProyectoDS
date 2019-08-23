/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
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
public class RepartidorTest {
    
    public RepartidorTest() {
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

   
    @Test
    public void testObtenerRepartidor() {
        System.out.println("obtenerRepartidor");
        String idRepartidor = "0950950950";
        DataBase bdtest = new BD();
        bdtest.getConexion();
        Repartidor result = Repartidor.obtenerRepartidor(idRepartidor, bdtest);
        assertNotNull( result);
    }

   
    
}
