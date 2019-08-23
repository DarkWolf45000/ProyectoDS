/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import singleton.Local;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Logger;
/**
 *
 * @author LuisEduardo
 */
public class PedidoLocal extends Pedido {
    private Local local;
    private HashMap<Producto,Integer> listProducto;

    public PedidoLocal(int id, String estadoEntrega, DataBase db) {
        super(id, estadoEntrega, db);
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public HashMap<Producto, Integer> getListProducto() {
        return listProducto;
    }

    public void setListProducto(HashMap<Producto, Integer> listProducto) {
        this.listProducto = listProducto;
    }
    
    
    public void cargarDatos(int idSucursal){
        //Averiguar si es local es matriz o sucursal
        this.cargarDatosLocal(idSucursal);
        //cargar productos
        this.listProducto= Producto.cargarDatosPedido(db, this.id);
        
    }
    
    public void cargarDatosLocal(int idSucursal){
        try{
            String sql= "{call verificarMatriz(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idSucursal);
            ResultSet rs = cst.executeQuery();
            rs.next();
            if(rs.getInt(2)==1){
                this.local=Local.createMatriz(db, idSucursal,rs.getString(1));
            }else{
                Local lc=new Local(idSucursal,this.db);
                lc.setDireccion(rs.getString(1));
                this.local=lc;
            }
            
        }catch (Exception e){
            Logger.getLogger(PedidoLocal.class.getName()).warning("Error en conexión datos local");
        }
    }
    
    public static void cargarDatosSucursalBodega(DataBase db, int idBodega,List<Pedido> lp){
        try{
            String sql= "{call obtenerPedidosSucursalBodega(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idBodega);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                PedidoLocal pl=new PedidoLocal(rs.getInt(1),rs.getString(2),db);
                pl.cargarDatos(rs.getInt(3));
                lp.add(pl);
            }
        }catch (Exception e){
            Logger.getLogger(PedidoLocal.class.getName()).warning("Error en conexión sucursal bodega");
        }
        
    }

    @Override
    public String getDireccion() {
        return this.local.getDireccion();
    }
    
    public void registrarPedido(int idBodega){
        try{
            //creo pedido
            String sql= "{call insertarPedido(?,?,?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, this.id);
            cst.setInt(2, idBodega);
            cst.setString(3, this.estadoEntrega);
            cst.executeQuery();
            for(Producto p:this.listProducto.keySet()){
                //creo producto_pedido
                sql= "{call insertarProductoPedido(?,?,?)}";
                cst=db.getC().prepareCall(sql);
                cst.setInt(1, this.id);
                cst.setInt(2, p.getIdProducto());
                cst.setInt(3, this.listProducto.get(p));
                cst.executeQuery();
            }
            
            //creo pedido_local
            sql= "{call insertarProductoLocal(?,?)}";
            cst=db.getC().prepareCall(sql);
            cst.setInt(1, this.id);
            cst.setInt(2, this.local.getIdlocal());
            cst.executeQuery();
        }catch (Exception e){
            Logger.getLogger(PedidoLocal.class.getName()).warning("Error en conexión registar pedido");
        }
    }
    
}
