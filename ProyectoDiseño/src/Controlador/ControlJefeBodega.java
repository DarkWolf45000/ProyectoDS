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
import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author LuisEduardo
 */
public class ControlJefeBodega {
    
    public void crearRuta(TextArea ta, ArrayList<Pedido> ped,JefeBodega jf){
        Ruta r=jf.crearRuta(ped, ta.getText());
        
        if(r.getRep()==null){
            //alerta no hay repartidor disponible
        }else{
            r.imprimirRuta();
        }
        
    }
    
    public ArrayList<Pedido> obtenerPedidos(){
        
        return null;
    }
    
    public Pedido consultarPedido(String id){
        Pedido p=null;
        try{
        int idp=Integer.parseInt(id);
            //obtener pedido
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
            //alerta
            return false;
        }
        
        //query para obtener repartidor
        Repartidor rep=null;
        
        
        
        
        //query para actualizar el pedido en la base de datos
        return true;
    }
    
    public JefeBodega cargarDatos(User u){
        Usuario us=(Usuario) u;
        JefeBodega jb= new JefeBodega(us.getUsuario(),us.getClave(),us.getTipoU(),ControlLogIn.db,us.getCedula(),us.getNombre(),us.getApellido());
        
        // obtener bodega
        // obtener repartidores
        // obtener empleados adicionales
        // obtener pedidos
        //obtener productos
        //CrearJefeBodega
    
        return jb;
    }
    
    
}
