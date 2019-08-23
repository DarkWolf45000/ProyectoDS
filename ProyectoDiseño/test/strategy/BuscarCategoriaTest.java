/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import controlador.ControlLogIn;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BuscarCategoriaTest {
    
    public BuscarCategoriaTest() {
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
     * Test of Buscarproducto method, of class BuscarCategoria.
     */
    @Test
    public void testBuscarproducto() throws SQLException {
        System.out.println("Buscarproducto Categoria");
        ControlLogIn cli=new ControlLogIn();
        String parametro = "Alimentos";
        BuscarCategoria instance = new BuscarCategoria();
        ResultSet result = instance.Buscarproducto(parametro);
        assertTrue(result.next());
    }
    
}
