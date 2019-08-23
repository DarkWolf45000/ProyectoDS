/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Diego Yance
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class BD implements DataBase {

    private Connection c;

    //Se realiza metodo que retorna la Conexion
    public Connection getConexion() {
        c = null;
        //Se Realiza la conexion  
        try { //cambiar la ip dependiendo del contenedor
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBProyecto", "root", "1234");
            //Verfificar que la conexion fue exitosa

        } //Capturando la excepcion
        catch ( SQLException e) {
            Logger.getLogger(BD.class.getName()).warning("Error en conexión");
        }
        //Finalmente se retorna
        return (c);
    }

    //Metodo para Desconectar de la Base de datos
    public void Desconectar() {
        c = null;


    }

    @Override
    public Connection getC() {
        return c;
    }

}
