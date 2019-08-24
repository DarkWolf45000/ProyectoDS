/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.BD;
import modelo.Pedido;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisEduardo
 */
public class ControlJefeBodegaTest {
    
    

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
