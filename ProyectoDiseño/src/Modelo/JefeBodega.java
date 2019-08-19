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
public class JefeBodega extends Usuario{
    private Bodega bodega;

    public JefeBodega(String usuario, String clave, String tipou, DataBase db, String cedula, String nombre, String apellido) {
        super(usuario, clave, tipou, db, cedula, nombre, apellido);
    }

    public void cargarDatos(){
        Bodega bod=new Bodega(this.db);
        bod.cargarBodega(this.cedula);
        this.bodega=bod;
        this.bodega.setJefeBodega(this);
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    public Ruta crearRuta(ArrayList<Pedido> listp,String camino){
        Ruta r=new Ruta(listp,camino);
        if(this.AsignarRepartidor(r)){
            return r;
        }else{
            r.setRep(null);
            return r;
        }
    }
    
    public boolean AsignarRepartidor(Ruta r){
        Repartidor rep=this.bodega.repartidorDisponible();
        if(rep==null){
            return false;
        }else{
            r.setRep(rep);
            return true;
        }
        
    }
    
    public boolean ColocarRepartidor(String idRep){
        this.bodega.agregarRepartidor(idRep);
        return true;
    }
}
