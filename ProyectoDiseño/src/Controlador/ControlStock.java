package Controlador;

import Modelo.Gerente;
import Modelo.Producto;
import Modelo.User;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;


/**
 *
 * @author LuisEduardo
 */
public class ControlStock {
    
    
    public List<Producto> obtenerProductos(String parametro,String criterio){
        ArrayList<Producto> lib;
        if(criterio.equalsIgnoreCase("Por nombre")){
            lib=Producto.buscarNombre(parametro);
        }else if(criterio.equalsIgnoreCase("Por descripcion")){
            lib=Producto.buscarDescripcion(parametro);
        }else if(criterio.equalsIgnoreCase("Por categoria")){
            lib=Producto.buscarCategoria(parametro);
        }else{
            lib=Producto.productosTodos();
        }
        return lib;
    }
     public Producto consultarProducto(String nombre){
        ArrayList<Producto> p=new ArrayList<>();
       
        try{
            p=Producto.buscarNombre(nombre);
            if(p==null){
                return null;
            }
            return p.get(0);
        }catch(Exception e){
            //alerta de que se escribieron letras en vez de numeros
        }
        return null;
    }       

    public boolean actualizarPrecio(String id, String nombre, String categoria, String precio) {
        if(id.isEmpty() && nombre.isEmpty() && categoria.isEmpty() && precio.isEmpty()){
            return false;
        }
        int idPrec;
        float prec;
        try{
             idPrec= Integer.parseInt(id);
             prec= Float.parseFloat(precio);
        } catch (Exception e){
            return false;
            //crear alerta de que datos ingresados estan en formato invalido
        }
        Producto.actualizarprecio(idPrec, nombre, categoria, prec);
        return true;
    }
            
    public boolean crearPedido(ObservableList<Producto> listp,User u){
        Usuario us=(Usuario) u;
        Gerente g=new Gerente(us.getUsuario(),us.getClave(),us.getTipoU(),ControlLogIn.db,us.getCedula(),us.getNombre(),us.getApellido());
        ArrayList<Producto> lp=new ArrayList<>();
        for(Producto p:listp){
            if(p.getIsdeseado().isSelected()){
                lp.add(p);
            }
        }
        
        g.crearPedido(lp);
        for(Producto p:listp){
            if(p.getIsdeseado().isSelected()){
                p.getIsdeseado().setSelected(false);
                p.setCantDisp(p.getCantDisp()-Integer.parseInt(p.getCantdeseada().getText()));
                p.getCantdeseada().clear();
            }
        }
        return true;
    }

    public boolean actualizarStock(String id, String idbod, String cant) {
        if(id.isEmpty() && idbod.isEmpty() && cant.isEmpty()){
            return false;
        }
        int idProd;
        int idBod;
        int Cant;
        try{
             idProd= Integer.parseInt(id);
             idBod= Integer.parseInt(idbod);
             Cant= Integer.parseInt(cant);
        } catch (Exception e){
            return false;
            //crear alerta de que datos ingresados estan en formato invalido
        }
        Producto.actualizarStock(idProd,idBod, Cant);
        return true;
    }
    public boolean ingresarStock(String id, String idbod, String cant) {
        if(id.isEmpty() && idbod.isEmpty() && cant.isEmpty()){
            return false;
        }
        int idProd;
        int idBod;
        int Cant;
        try{
             idProd= Integer.parseInt(id);
             idBod= Integer.parseInt(idbod);
             Cant= Integer.parseInt(cant);
        } catch (Exception e){
            return false;
            //crear alerta de que datos ingresados estan en formato invalido
        }
        Producto.ingresarStock(idProd,idBod, Cant);
        return true;
    }    
}
