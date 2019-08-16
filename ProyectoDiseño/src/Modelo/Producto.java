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
public class Producto {
    private String idProducto;
    private String descripcion;
    private float precio;
    private int cantDisp;
    private String modelo;
    private DataBase db;
    private Buscar bq;

    public Producto(String idProducto, String descripcion, float precio, int cantDisp, String modelo, DataBase db, Buscar bq) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantDisp = cantDisp;
        this.modelo = modelo;
        this.db = db;
        this.bq = bq;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(int cantDisp) {
        this.cantDisp = cantDisp;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public Buscar getBq() {
        return bq;
    }

    public void setBq(Buscar bq) {
        this.bq = bq;
    }
    
    
    
}
