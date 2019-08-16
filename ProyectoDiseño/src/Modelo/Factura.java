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
public class Factura {
    private HashMap<Integer,Producto> listProducto;
    private LocalDate fecha;
    private int precioTotal;
    private int DataBase;

    public Factura(HashMap<Integer, Producto> listProducto, LocalDate fecha, int precioTotal, int DataBase) {
        this.listProducto = listProducto;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.DataBase = DataBase;
    }

    public HashMap<Integer, Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(HashMap<Integer, Producto> listProducto) {
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

    public int getDataBase() {
        return DataBase;
    }

    public void setDataBase(int DataBase) {
        this.DataBase = DataBase;
    }
    
}
