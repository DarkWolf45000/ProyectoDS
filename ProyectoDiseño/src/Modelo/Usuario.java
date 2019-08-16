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
public class Usuario extends Persona implements User{
    protected String usuario;
    protected String clave;
    protected String tipou;
    protected DataBase db;

    public Usuario(String usuario, String clave, String tipou, DataBase db, String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
        this.usuario = usuario;
        this.clave = clave;
        this.tipou = tipou;
        this.db = db;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    public void setTipou(String tipou) {
        this.tipou = tipou;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    @Override
    public String getTipoU() {
        return this.tipou;
    }
    
    
    
}
