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
public class GerenteTest {
   

    /**
     * Test of getLocal method, of class Gerente.
     */
    
    
    //Se comprueba que retorne el id del local correspondiente al gerente
    @Test
    public void testObteneridLocal() {
        BD bdtest = new BD();
        bdtest.getConexion();
        Gerente instance = new Gerente("lsalazar","espol2","gerente",bdtest,"0920920920","Luis","Salazar");
        int result = instance.obteneridLocal();
        assertEquals(1, result);
    }
    
}
