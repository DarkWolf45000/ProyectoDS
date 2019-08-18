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
public class PedidoLocal extends Pedido {
    private Local local;
    private HashMap<Integer,Producto> listProducto;

    public PedidoLocal(Local local, HashMap<Integer, Producto> listProducto, String id, String estadoEntrega, String direccion, DataBase db) {
        super(id, estadoEntrega, direccion, db);
        this.local = local;
        this.listProducto = listProducto;
    }

    
    
    
    
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public HashMap<Integer, Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(HashMap<Integer, Producto> listProducto) {
        this.listProducto = listProducto;
    }
    
    
}
