/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisEduardo
 */
public class RepartidorTest {
  
  

    //Se comprueba que retorne un repartidor al enviar la id correspondinte
    @Test
    public void testObtenerRepartidor() {
        String idRepartidor = "0950950950";
        DataBase bdtest = new BD();
        bdtest.getConexion();
        Repartidor result = Repartidor.obtenerRepartidor(idRepartidor, bdtest);
        assertNotNull( result);
    }

   
    
}
