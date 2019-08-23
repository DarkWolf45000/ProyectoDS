/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LuisEduardo
 */
public class Tramite {
    protected Cliente cliente;
    protected LocalDate fecha;
    protected Map<Producto,Integer> listProducto = new HashMap<>();
    protected DataBase db;

    public Tramite(Cliente cliente,  DataBase db) {
        this.cliente = cliente;
        this.db = db;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

  

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Map<Producto, Integer> getListProducto() {
        return listProducto;
    }

    public void setListProducto(Map<Producto, Integer> listProducto) {
        this.listProducto = listProducto;
    }

    

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    
    
}
