/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author LuisEduardo
 */
public class Tramite {
    private Cliente cliente;
    private int idTramite;
    private LocalDate fecha;
    private HashMap<Integer,Producto> listProducto;
    private DataBase db;

    public Tramite(Cliente cliente, int idTramite, LocalDate fecha, HashMap<Integer, Producto> listProducto, DataBase db) {
        this.cliente = cliente;
        this.idTramite = idTramite;
        this.fecha = fecha;
        this.listProducto = listProducto;
        this.db = db;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public HashMap<Integer, Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(HashMap<Integer, Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    
    
}
