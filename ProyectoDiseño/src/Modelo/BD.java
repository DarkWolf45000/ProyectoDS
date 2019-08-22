/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Diego Yance
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD implements DataBase{
    public Connection c;
    //Se realiza metodo que retorna la Conexion
    public Connection getConexion(){
        c=null;
        //Se Realiza la conexion  
        try{
            Class.forName("com.mysql.jdbc.Driver"); //cambiar la ip dependiendo del contenedor
            c=  DriverManager.getConnection("jdbc:mysql://localHost:3306/DBProyecto","root","1234");
            //Verfificar que la conexion fue exitosa
            
                System.out.println("Conexion establecida");
            
        }
        //Capturando la excepcion
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion"+ e);
        }
        //Finalmente se retorna
        return(c);
    }
    //Metodo para Desconectar de la Base de datos
    public void Desconectar(){
        c=null;
        
            System.out.println("Conexion finalizada");
        
    }

    @Override
    public Connection getC() {
        return c;
    }
 
    
    
}
