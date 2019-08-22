/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author LuisEduardo
 */
public class Bodega {
    private int idbodega; //
    private ArrayList<Repartidor> listaRepartidores;//
    private Queue<Repartidor> colaRepartidores;//
    private ArrayList<Usuario> listaEmpleados;
    private ArrayList<Pedido> listaPedidos;//
    private JefeBodega jefeBodega; //
    private ArrayList<Producto> listaProductos;//
    private String direccion;//
    private DataBase db;//

    public Bodega(DataBase db) {
        this.db = db;
    }

    public List<Repartidor> getListaRepartidores() {
        return listaRepartidores;
    }

    public void setListaRepartidores(ArrayList<Repartidor> listaRepartidores) {
        this.listaRepartidores = listaRepartidores;
    }

    public Queue<Repartidor> getColaRepartidores() {
        return colaRepartidores;
    }

    public void setColaRepartidores(Queue<Repartidor> colaRepartidores) {
        this.colaRepartidores = colaRepartidores;
    }

    public ArrayList<Usuario> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Usuario> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public JefeBodega getJefeBodega() {
        return jefeBodega;
    }

    public void setJefeBodega(JefeBodega jefeBodega) {
        this.jefeBodega = jefeBodega;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }
    
    public Repartidor repartidorDisponible(){
        return this.colaRepartidores.poll();
    }
    
    public void agregarRepartidor(String idrep){
        
        for(Repartidor rep:this.listaRepartidores){
            if(rep.getCedula().equalsIgnoreCase(idrep)){
                this.colaRepartidores.offer(rep);
            }
        }
    }
    
    public void cargarBodega(String idJefe){
        try{
            String sql= "{call obtenerBodega(?)}";
            CallableStatement cst=this.db.getC().prepareCall(sql);
            cst.setString(1, idJefe);
            ResultSet rs = cst.executeQuery();
            rs.next();
            this.idbodega=rs.getInt(1);
            this.direccion=rs.getString(2);
        }catch (Exception e){
            System.out.println(e);
        }
        this.cargarDatos();
        
    }
    
    private void cargarDatos(){
        this.listaRepartidores=Repartidor.cargarDatos(db,this.idbodega);
        this.colaRepartidores=new LinkedList<>(this.listaRepartidores);
        this.listaProductos=Producto.cargarDatosBodega(db, idbodega);
        this.cargarPedidos();
    }
    
    public void cargarPedidos(){
        ArrayList<Pedido> listp=new ArrayList<>();
        PedidoLocal.cargarDatosSucursalBodega(db, idbodega,listp);
        PedidoCliente.cargarDatosClienteBodega(db, idbodega, listp);
        this.listaPedidos=listp;
    }
    
    public ArrayList<Pedido> pedidosAEntregar(){
        ArrayList<Pedido> listp=new ArrayList<>();
        for(Pedido p:this.listaPedidos){
            if(!p.getEstadoEntrega().equalsIgnoreCase("Entregado") && !p.getEstadoEntrega().equalsIgnoreCase("En_Proceso")){
                listp.add(p);
            }
        }
        return listp;
    }
    
    public static int obteneridBodega(int idproducto, int cantidad,DataBase db){
        try{
            String sql= "{call obtenerBodegaPorProducto(?,?)}";
            System.out.println(db);
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idproducto);
            cst.setInt(2, cantidad);
            ResultSet rs = cst.executeQuery();
            rs.next();
            return rs.getInt(1);
            
        }catch (Exception e){
            System.out.println("aqui sale el primero");
            System.out.println(e);
        }
        return 0;
    } 
    
    public static void actualizarProductoBodega(int idBodega, int idProducto, int cantidad,DataBase db){
        try{
            String sql= "{call actualizarBodegaPorProducto(?,?,?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setInt(1, idBodega);
            cst.setInt(2, idProducto);
            cst.setInt(3, cantidad);
            cst.executeQuery();
            
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
}
