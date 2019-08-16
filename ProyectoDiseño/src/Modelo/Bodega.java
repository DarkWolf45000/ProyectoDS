/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author LuisEduardo
 */
public class Bodega {
    private ArrayList<Repartidor> listaRepartidores;
    private Queue<Repartidor> colaRepartidores;
    private ArrayList<Usuario> listaEmpleados;
    private ArrayList<Pedido> listaPedidos;
    private JefeBodega jefeBodega;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Producto> listaProductos;
    private String direccion;
    private DataBase db;

    public Bodega(ArrayList<Repartidor> listaRepartidores, Queue<Repartidor> colaRepartidores, ArrayList<Usuario> listaEmpleados, ArrayList<Pedido> listaPedidos, JefeBodega jefeBodega, ArrayList<Vehiculo> listaVehiculos, ArrayList<Producto> listaProductos, String direccion, DataBase db) {
        this.listaRepartidores = listaRepartidores;
        this.colaRepartidores = colaRepartidores;
        this.listaEmpleados = listaEmpleados;
        this.listaPedidos = listaPedidos;
        this.jefeBodega = jefeBodega;
        this.listaVehiculos = listaVehiculos;
        this.listaProductos = listaProductos;
        this.direccion = direccion;
        this.db = db;
    }

    public ArrayList<Repartidor> getListaRepartidores() {
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

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
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
    
    public void agregarRepartidor(Repartidor rep){
        this.colaRepartidores.offer(rep);
    }
    
}
