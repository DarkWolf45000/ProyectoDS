/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiseño;

import Controlador.ControlJefeBodega;
import Modelo.Bodega;
import Modelo.BD;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/** 
 *
 * @author Charles
 */
public class LogInTest {
    
    public LogInTest() {
       
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
    
    //Se espera que al cargar la Bodega, se tenga un id
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
        ArrayList<Producto> h = Producto.buscarNombre("Aromatel");
        assertNotNull(h);
        
    }
    
    
}
