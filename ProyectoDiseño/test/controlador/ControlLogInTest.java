/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LuisEduardo
 */
public class ControlLogInTest {
    
    

        /**
     * Test of verificar method, of class ControlLogIn.
     */
    //Se comprueba si es que se realiza correctamente la verificacion de los usuarios 
    @Test 
    public void testVerificar() {
        String usuario = "lsalazar3";
        String contra = "espol2";
        ControlLogIn instance = new ControlLogIn();
        boolean result = instance.verificar(usuario, contra);
        assertFalse(result);
        
    }
    
    //Se comprueba que regrese un objeto gerente al ingresar el usuario y contraseña correctos
    @Test
    public void testObtenerGerente() throws Exception {
        String usuario = "lsalazar";
        String contra = "espol2";
        ControlLogIn instance = new ControlLogIn();
        User result = instance.obtenerGerente(usuario, contra);
        assertNotNull(result);
    }

    //Se comprueba que regrese un objeto JefeBodega al ingresar el usuario y contraseña correctos
    @Test
    public void testObtenerJefeBodega() throws Exception {
        String usuario = "lpod";
        String contra = "espol4";
        ControlLogIn instance = new ControlLogIn();
        User result = instance.obtenerJefeBodega(usuario, contra);
        assertNotNull(result);
    }

   
    
}

    

