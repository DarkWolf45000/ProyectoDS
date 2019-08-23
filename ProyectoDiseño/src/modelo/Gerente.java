/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import singleton.Local;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 *
 * @author LuisEduardo
 */
public class Gerente extends Usuario{
    private Local local;

    public Gerente(String usuario, String clave, String tipou, DataBase db, String cedula, String nombre, String apellido) {
        super(usuario, clave, tipou, db, cedula, nombre, apellido);
    }
    
    
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    public boolean crearPedido(ArrayList<Producto> lp){
        HashMap<Integer,ArrayList<Producto>> hmp=new HashMap<>();
        for(Producto p:lp){
            int idBodega= Bodega.obteneridBodega(p.getIdProducto(), p.getCantDisp(),this.db);
            if(hmp.keySet().contains(idBodega)){
                ArrayList<Producto> ltemp=hmp.get(idBodega);
                ltemp.add(p);
                hmp.put(idBodega, ltemp);
            }else{
                ArrayList<Producto> listn=new ArrayList<>();
                listn.add(p);
                hmp.put(idBodega, listn);
            }
            Bodega.actualizarProductoBodega(idBodega, p.getIdProducto(), p.getCantDisp()-Integer.parseInt(p.getCantdeseada().getText()),this.db);
        }
        int idLocal=this.obteneridLocal();
        for(Integer i: hmp.keySet()){
            PedidoLocal pl=new PedidoLocal(Pedido.obtenerSiguienteId(db),"Aentregar",this.db);
            pl.cargarDatosLocal(idLocal);
            HashMap<Producto,Integer> hm=new HashMap<>();
            for(Producto p: hmp.get(i)){
                hm.put(p, Integer.parseInt(p.getCantdeseada().getText()));
            }
            pl.setListProducto(hm);
            pl.registrarPedido(i);
        }
        
        return true;
    }
    
    public int obteneridLocal(){
        try{
            String sql= "{call obtenerLocalporGerente(?)}";
            CallableStatement cst=db.getC().prepareCall(sql);
            cst.setString(1, this.cedula);
            ResultSet rs = cst.executeQuery();
            rs.next();
            return rs.getInt(1);
            
        }catch (Exception e){
            Logger.getLogger(Gerente.class.getName()).warning("Error en conexión obtener id local");
        }
        return 0;
    }
    
}
