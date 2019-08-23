
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisEduardo
 */
public class Ruta {
    private Repartidor rep;
    private List<Pedido> listPedidos = new ArrayList<>();
    private String camino;

    public Ruta(List<Pedido> listPedidos, String camino) {
        this.listPedidos = listPedidos;
        this.camino = camino;
    }

    public Repartidor getRep() {
        return rep;
    }

    public void setRep(Repartidor rep) {
        this.rep = rep;
    }

    

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(List<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }

    public String getCamino() {
        return camino;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public void imprimirRuta(){
        System.out.println(this.camino);
    }
}
