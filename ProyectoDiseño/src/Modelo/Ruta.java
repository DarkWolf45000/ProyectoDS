/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author LuisEduardo
 */
public class Ruta {
    private Repartidor rep;
    private ArrayList<Pedido> listPedidos;
    private String camino;

    public Ruta(ArrayList<Pedido> listPedidos, String camino) {
        this.listPedidos = listPedidos;
        this.camino = camino;
    }

    public Repartidor getRep() {
        return rep;
    }

    public void setRep(Repartidor rep) {
        this.rep = rep;
    }

    

    public ArrayList<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(ArrayList<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public void imprimirRuta(){
        
    }
}
