/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author LuisEduardo
 */
public class PedidoCliente extends Pedido{
    private Cliente cliente;
    private Venta venta;

    public PedidoCliente(Cliente cliente, Venta venta, String id, String estadoEntrega, String direccion, DataBase db) {
        super(id, estadoEntrega, direccion, db);
        this.cliente = cliente;
        this.venta = venta;
    }

   

    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
}
