/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author LuisEduardo
 */
public class Cliente extends Persona{
    private String direccion;
    private String numero;
    private String email;

    public Cliente(String direccion, String numero, String email, String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        this.direccion = direccion;
        this.numero = numero;
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static Cliente cargarCliente(String idCliente,DataBase db){
        try{
            String sql= "{call obtenerCliente(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setString(1, idCliente);
            ResultSet rs = cst.executeQuery();
            rs.next();
            Cliente c=new Cliente(rs.getString(5),rs.getString(6),rs.getString(4),rs.getString(1),rs.getString(2),rs.getString(3));
            return c;
            
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
}
