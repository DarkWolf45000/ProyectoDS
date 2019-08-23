package Controlador;


import Modelo.JefeBodega;
import Modelo.Pedido;
import Modelo.Ruta;
import Modelo.User;
import Modelo.Usuario;
import java.util.List;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

/**
 *
 * @author LuisEduardo
 */
public class ControlJefeBodega {
    
    public boolean crearRuta(TextArea ta, List<Pedido> ped,JefeBodega jf){
        Ruta r=jf.crearRuta(ped, ta.getText());
        
        if(r.getRep()==null){
            //alerta no hay repartidor disponible
            Logger.getLogger("No hay repatidor");
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
        
      
        int idped=0;
        try{
            
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
