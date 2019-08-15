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
public class Gerente extends Usuario{
    private Local local;

    public Gerente(String usuario, String clave, String tipou, DataBase db, String cedula, String nombre, String apellido) {
        super(usuario, clave, tipou, db, cedula, nombre, apellido);
    }
    
    
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    
}
