/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    
    
    
}
