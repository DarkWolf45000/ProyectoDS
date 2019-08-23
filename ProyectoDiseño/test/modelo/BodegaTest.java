/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControlJefeBodega;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisEduardo
 */

public class BodegaTest {
    @Test
    public void testBodega(){
        BD bdtest = new BD();
        bdtest.getConexion();
        Bodega bodeg = new Bodega(bdtest);
        bodeg.cargarBodega("0940940940");
        assertEquals("Costa Este",bodeg.getDireccion());
        
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
