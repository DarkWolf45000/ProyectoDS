/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author LuisEduardo
 */
public class Factura {
    private Map<Integer,Producto> listProducto;
    private LocalDate fecha;
    private int precioTotal;
    private DataBase db;

    public Factura(Map<Integer, Producto> listProducto, LocalDate fecha, int precioTotal, DataBase DataBase) {
        this.listProducto = listProducto;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.db = DataBase;
    }

    public Map<Integer, Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(Map<Integer, Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public DataBase getDataBase() {
        return db;
    }

    public void setDataBase(DataBase DataBase) {
        this.db = DataBase;
    }
    
}
