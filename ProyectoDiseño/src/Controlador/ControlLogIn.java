/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdminDecorator;
import Modelo.BD;
import Modelo.DataBase;
import Modelo.User;
import Modelo.Usuario;
import Vistas.Pedidos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LuisEduardo
 */
public class ControlLogIn {
    public static DataBase db=new BD();
    public static Connection cn=db.getConexion();
    
    public boolean verificar (String usuario, String contraseña){
        try{
            String sql= "{call verificar(?,?)}";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setString(1,usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                String user=rs.getString(1);
                String pass=rs.getString(2);
                if(usuario.equals(user)&& contraseña.equals(pass)){
                  //  System.out.println("yes");
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
   
    public User obtenerAdministrador(String usuario, String contraseña){
        try{
            String sql= "{call obtenerAdmins(?,?)}";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setString(1,usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            
            while(rs.next()){
                Usuario u=new Usuario(usuario,contraseña,"Administrador",null,rs.getString(1),rs.getString(2),rs.getString(3));
               // System.out.println(u.getNombre()+" "+u.getApellido());
                return u;
            }
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
    
    public User obtenerGerente(String usuario, String contraseña){
        try{
            String sql= "{call obtenerGerente(?,?)}";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setString(1,usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            
            while(rs.next()){
                Usuario u=new Usuario(usuario,contraseña,"Gerente",null,rs.getString(1),rs.getString(2),rs.getString(3));
                //System.out.println(u.getNombre()+" "+u.getApellido());
                return u;
            }
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
    
    public User obtenerVendedor(String usuario, String contraseña){
        try{
            String sql= "{call obtenerVendedor(?,?)}";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setString(1,usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            
            while(rs.next()){
                Usuario u=new Usuario(usuario,contraseña,"Vendedor",null,rs.getString(1),rs.getString(2),rs.getString(3));
              //  System.out.println(u.getNombre()+" "+u.getApellido());
                return u;
            }
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
    
    public User obtenerJefeBodega(String usuario, String contraseña){
        try{
            String sql= "{call obtenerJefeBodega(?,?)}";
            CallableStatement cst=cn.prepareCall(sql);
            cst.setString(1,usuario);
            cst.setString(2, contraseña);
            ResultSet rs = cst.executeQuery();
            
            while(rs.next()){
                Usuario u=new Usuario(usuario,contraseña,"JefeBodega",null,rs.getString(1),rs.getString(2),rs.getString(3));
               // System.out.println(u.getNombre()+" "+u.getApellido());
                return u;
            }
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
        return null;
    }
    
    public void siguientePantalla(String usuario, String cont,Stage st,Scene scp){
        User u=obtenerAdministrador(usuario,cont);
        if(u!=null){
            //cabiar al menu de admin
            System.out.println("Admin");
            st.setScene(AdminDecorator.menuAdmin(u,st,scp));
        }
        u=obtenerGerente(usuario,cont);
        if(u!=null){
            System.out.println("Gerente");
        }
        u=obtenerVendedor(usuario,cont);
        if(u!=null){
            System.out.println("Vendedor");
        }
        u=obtenerJefeBodega(usuario,cont);
        if(u!=null){
            st.setScene(Pedidos.menuJefeBodega(u,st,scp));
            System.out.println("JefeBodega");
        }
    }
}
