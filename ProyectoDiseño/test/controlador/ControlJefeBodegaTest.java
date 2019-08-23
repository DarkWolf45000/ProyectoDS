/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javafx.scene.control.TextArea;
import modelo.BD;
import modelo.JefeBodega;
import modelo.Pedido;
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
public class ControlJefeBodegaTest {
    
    public ControlJefeBodegaTest() {
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

   //Se espera que al consultar un pedido por su id, lo devuelva
    @Test
    public void testConsultaPedido(){
         BD bdtest = new BD();
        bdtest.getConexion();
        ControlJefeBodega cjb = new ControlJefeBodega();
        Pedido p = cjb.consultarPedido("1",bdtest);
        assertNotNull(p);
    }
    
    
}
