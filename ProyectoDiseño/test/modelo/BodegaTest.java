/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    public void testGetListaRepartidores() {
        System.out.println("getListaRepartidores");
        Bodega instance = null;
        List<Repartidor> expResult = null;
        List<Repartidor> result = instance.getListaRepartidores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaRepartidores method, of class Bodega.
     */
    @Test
    public void testSetListaRepartidores() {
        System.out.println("setListaRepartidores");
        List<Repartidor> listaRepartidores = null;
        Bodega instance = null;
        instance.setListaRepartidores(listaRepartidores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColaRepartidores method, of class Bodega.
     */
    @Test
    public void testGetColaRepartidores() {
        System.out.println("getColaRepartidores");
        Bodega instance = null;
        Queue<Repartidor> expResult = null;
        Queue<Repartidor> result = instance.getColaRepartidores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColaRepartidores method, of class Bodega.
     */
    @Test
    public void testSetColaRepartidores() {
        System.out.println("setColaRepartidores");
        Queue<Repartidor> colaRepartidores = null;
        Bodega instance = null;
        instance.setColaRepartidores(colaRepartidores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaEmpleados method, of class Bodega.
     */
    @Test
    public void testGetListaEmpleados() {
        System.out.println("getListaEmpleados");
        Bodega instance = null;
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getListaEmpleados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaEmpleados method, of class Bodega.
     */
    @Test
    public void testSetListaEmpleados() {
        System.out.println("setListaEmpleados");
        List<Usuario> listaEmpleados = null;
        Bodega instance = null;
        instance.setListaEmpleados(listaEmpleados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPedidos method, of class Bodega.
     */
    @Test
    public void testGetListaPedidos() {
        System.out.println("getListaPedidos");
        Bodega instance = null;
        List<Pedido> expResult = null;
        List<Pedido> result = instance.getListaPedidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPedidos method, of class Bodega.
     */
    @Test
    public void testSetListaPedidos() {
        System.out.println("setListaPedidos");
        List<Pedido> listaPedidos = null;
        Bodega instance = null;
        instance.setListaPedidos(listaPedidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJefeBodega method, of class Bodega.
     */
    @Test
    public void testGetJefeBodega() {
        System.out.println("getJefeBodega");
        Bodega instance = null;
        JefeBodega expResult = null;
        JefeBodega result = instance.getJefeBodega();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJefeBodega method, of class Bodega.
     */
    @Test
    public void testSetJefeBodega() {
        System.out.println("setJefeBodega");
        JefeBodega jefeBodega = null;
        Bodega instance = null;
        instance.setJefeBodega(jefeBodega);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaProductos method, of class Bodega.
     */
    @Test
    public void testGetListaProductos() {
        System.out.println("getListaProductos");
        Bodega instance = null;
        List<Producto> expResult = null;
        List<Producto> result = instance.getListaProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaProductos method, of class Bodega.
     */
    @Test
    public void testSetListaProductos() {
        System.out.println("setListaProductos");
        List<Producto> listaProductos = null;
        Bodega instance = null;
        instance.setListaProductos(listaProductos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Bodega.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Bodega instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Bodega.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Bodega instance = null;
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDb method, of class Bodega.
     */
    @Test
    public void testGetDb() {
        System.out.println("getDb");
        Bodega instance = null;
        DataBase expResult = null;
        DataBase result = instance.getDb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDb method, of class Bodega.
     */
    @Test
    public void testSetDb() {
        System.out.println("setDb");
        DataBase db = null;
        Bodega instance = null;
        instance.setDb(db);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repartidorDisponible method, of class Bodega.
     */
    @Test
    public void testRepartidorDisponible() {
        System.out.println("repartidorDisponible");
        Bodega instance = null;
        Repartidor expResult = null;
        Repartidor result = instance.repartidorDisponible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRepartidor method, of class Bodega.
     */
    @Test
    public void testAgregarRepartidor() {
        System.out.println("agregarRepartidor");
        String idrep = "";
        Bodega instance = null;
        instance.agregarRepartidor(idrep);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarBodega method, of class Bodega.
     */
    @Test
    public void testCargarBodega() {
        System.out.println("cargarBodega");
        String idJefe = "";
        Bodega instance = null;
        instance.cargarBodega(idJefe);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarPedidos method, of class Bodega.
     */
    @Test
    public void testCargarPedidos() {
        System.out.println("cargarPedidos");
        Bodega instance = null;
        instance.cargarPedidos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pedidosAEntregar method, of class Bodega.
     */
    @Test
    public void testPedidosAEntregar() {
        System.out.println("pedidosAEntregar");
        Bodega instance = null;
        List<Pedido> expResult = null;
        List<Pedido> result = instance.pedidosAEntregar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obteneridBodega method, of class Bodega.
     */
    @Test
    public void testObteneridBodega() {
        System.out.println("obteneridBodega");
        int idproducto = 0;
        int cantidad = 0;
        DataBase db = null;
        int expResult = 0;
        int result = Bodega.obteneridBodega(idproducto, cantidad, db);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarProductoBodega method, of class Bodega.
     */
    @Test
    public void testActualizarProductoBodega() {
        System.out.println("actualizarProductoBodega");
        int idBodega = 0;
        int idProducto = 0;
        int cantidad = 0;
        DataBase db = null;
        Bodega.actualizarProductoBodega(idBodega, idProducto, cantidad, db);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
