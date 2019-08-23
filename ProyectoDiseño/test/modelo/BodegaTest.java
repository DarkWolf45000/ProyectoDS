/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControlJefeBodega;
import java.util.List;
import java.util.Queue;
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
public class BodegaTest {
    
    public BodegaTest() {
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
     * Test of getListaRepartidores method, of class Bodega.
     */
    @Test
    public void testBodega(){
        BD bdtest = new BD();
        bdtest.getConexion();
        Bodega bodeg = new Bodega(bdtest);
        bodeg.cargarBodega("0940940940");
        assertEquals("Costa Este",bodeg.getDireccion());
        
    }
    //Se espera que al consultar un pedido por su id, lo devuelva
    @Test
    public void testConsultaPedido(){
         BD bdtest = new BD();
        bdtest.getConexion();
        ControlJefeBodega cjb = new ControlJefeBodega();
        Pedido p = cjb.consultarPedido("1");
        assertNotNull(p);
    }
    //Se espera que se regrese una lista de productos con un determinado nombre
    @Test
    public void testBuscoProductoNombre(){
        BD bdtest = new BD();
        bdtest.getConexion();
        List<Producto> h = Producto.buscarNombre("Aromatel");
        assertNotNull(h);
        
    }
    
}
