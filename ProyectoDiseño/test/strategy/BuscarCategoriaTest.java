/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import controlador.ControlLogIn;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisEduardo
 */
public class BuscarCategoriaTest {
   

    /**
     * Test of Buscarproducto method, of class BuscarCategoria.
     */
    //Se comprueba que se retorne productos al buscar usando la categoria correcta
    @Test
    public void testBuscarproducto() throws SQLException {
        ControlLogIn cli=new ControlLogIn();
        String parametro = "Alimentos";
        BuscarCategoria instance = new BuscarCategoria();
        ResultSet result = instance.Buscarproducto(parametro);
        assertTrue(result.next());
    }
    
}
