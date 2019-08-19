/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bodega;
import Modelo.JefeBodega;
import Modelo.Pedido;
import Modelo.Repartidor;
import Modelo.Ruta;
import Modelo.User;
import Modelo.Usuario;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author LuisEduardo
 */
public class ControlJefeBodega {
    
    public boolean crearRuta(TextArea ta, ArrayList<Pedido> ped,JefeBodega jf){
        Ruta r=jf.crearRuta(ped, ta.getText());
        
        if(r.getRep()==null){
            //alerta no hay repartidor disponible
            System.out.println("no hay repartidor :,v");
            return false;
        }else{
            for(Pedido p:ped){
                p.actualizarEstadoPedido(r.getRep().getCedula(), "En_Proceso");
            }
            r.imprimirRuta();
            return true;
        }
        
    }
    
    public Pedido consultarPedido(String id){
        Pedido p=null;
        try{
        int idp=Integer.parseInt(id);
            p=Pedido.obtenerPedido(idp, ControlLogIn.db);
            if(p==null){
                return null;
            }
            return p;
        }catch(Exception e){
            //alerta de que se escribieron letras en vez de numeros
        }
        return p;
    }
    
    public Boolean actualizarPedido(String id, String idRep,String horaS,String horaE,String estado,JefeBodega jb){
        if(id.equalsIgnoreCase("")){
            //alerta
            return false;
        }
        
        if(idRep.equalsIgnoreCase("")){
            //alerta
            return false;
        }
        
        if(horaS.equalsIgnoreCase("")){
            //alerta
            return false;
        }
        
        if(horaE.equalsIgnoreCase("")){
            //alerta
            return false;
        }
        
        if(estado.equalsIgnoreCase("")){
            //alerta
            return false;
        }
        
        int idrep=0;
        int idped=0;
        try{
            idrep=Integer.parseInt(idRep);
            idped=Integer.parseInt(id);
        }catch(Exception e){
            //alerta de numero format
            return false;
        }
        //Fecha
        Pedido.actualizarPedido(idped, idRep, estado, horaE, horaE, ControlLogIn.db);
        jb.ColocarRepartidor(idRep);
        return true;
    }
    
    public JefeBodega cargarDatos(User u){
        Usuario us=(Usuario) u;
        JefeBodega jb= new JefeBodega(us.getUsuario(),us.getClave(),us.getTipoU(),ControlLogIn.db,us.getCedula(),us.getNombre(),us.getApellido());
        jb.cargarDatos();
        return jb;
    }
    
    
}
