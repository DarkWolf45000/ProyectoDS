/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LuisEduardo
 */
public class PedidoCliente extends Pedido{
    private Cliente cliente;
    private Venta venta;

    public PedidoCliente(int id, String estadoEntrega, DataBase db) {
        super(id, estadoEntrega, db);
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

    @Override
    public String getDireccion() {
        return this.cliente.getDireccion();
    }
    
    public static void cargarDatosClienteBodega(DataBase db, int idBodega,ArrayList<Pedido> lp){
        try{
            String sql= "{call obtenerPedidosClienteBodega(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idBodega);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                PedidoCliente pc=new PedidoCliente(rs.getInt(1),rs.getString(2),db);
                pc.cargarDatos(rs.getString(3));
                lp.add(pc);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public void cargarDatos(String idCliente){
        //Cliente
        this.cliente=Cliente.cargarCliente(idCliente,db);
        //Venta
        this.venta=new Venta(this.cliente,db);
        this.venta.cargarDatosVenta(this.id);
    }
    
    
}
