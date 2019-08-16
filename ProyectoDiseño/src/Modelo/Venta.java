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
public class Venta extends Tramite{
    private Factura factura;
    private Pagar pagar;

    public Venta(Factura factura, Pagar pagar, Cliente cliente, int idTramite, LocalDate fecha, HashMap<Integer, Producto> listProducto, DataBase db) {
        super(cliente, idTramite, fecha, listProducto, db);
        this.factura = factura;
        this.pagar = pagar;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Pagar getPagar() {
        return pagar;
    }

    public void setPagar(Pagar pagar) {
        this.pagar = pagar;
    }
    
    
}
